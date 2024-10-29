package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import entity.bullets.Bullet;
import main.GamePanel;
import main.KeyHandler;
import stages.Stage;

import javax.imageio.ImageIO;

public class Player extends LivingEntity{
    public BufferedImage left, right, attack0, attack1, attack2, shoot;
    GamePanel gp;
    KeyHandler keyH;
    Stage stage;
    public int screenX;
    public int screenY;
    public int spriteNum = 1;
    final int MAXLIVES = 5;

    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    int cooldown = 0;

    public Player(GamePanel gp, Stage stage, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        this.stage = stage;

        screenX = gp.screenWidth/2 - (gp.trueTileS/2);
        screenY = gp.screenHeight/2 - (gp.trueTileS/2);

        setDefaultValues();
        getImage();
    }
    public void setDefaultValues(){
        x = gp.screenWidth/2 - (gp.trueTileS/2);;
        y = gp.screenHeight/2 - (gp.trueTileS/2);;
        speed = 8;
        sprite = "neutral";
        lives = MAXLIVES;
        hitbox = new Rectangle(x + gp.trueTileS/2,y + gp.trueTileS/2 ,12,12);
        collTrue = true;
    }

    public void getImage(){
        try{
            neutral = ImageIO.read(getClass().getResourceAsStream("/res/player/neutral.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/res/player/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/res/player/right.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(){
        updateBullets();
        if (keyH.uPressed || keyH.dPressed || keyH.lPressed || keyH.rPressed || keyH.shotPressed){
            if (keyH.focusPressed){
                speed = 4;
            }
            if (keyH.uPressed){
                y -= speed;
                hitbox.y -= speed;
            }
            if (keyH.dPressed){
                y += speed;
                hitbox.y += speed;
            }
            if (keyH.lPressed){
                sprite = "left";
                x -= speed;
                hitbox.x -= speed;
            }
            if (keyH.rPressed){
                sprite = "right";
                x += speed;
                hitbox.x += speed;
            }
            if (keyH.shotPressed && cooldown <= 0){
                bullets.add(new Bullet(gp,x, y, 10, 90, 0));
                cooldown = 5;
            }

        } else{
            sprite = "neutral";
        }
        speed = 8;
        cooldown--;
        iframes--;
        bounds();
    }

    private void updateBullets() {
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).isOffscreen()){
                bullets.remove(i);
            }
        }
        for (int i = 0; i < stage.eManager.enemies.size(); i++) {
            checkEmColl(stage.eManager.enemies.get(i));
        }
    }

    @Override
    public void draw(Graphics2D g){
        // Sprite
        if (iframes < 0) {
            switch (sprite){
                case "neutral":
                    image = neutral;
                    break;
                case "left":
                    image = left;
                    break;
                case "right":
                    image = right;
                    break;
            }
            g.drawImage(image, x, y, (int) (gp.trueTileS*1.5), (int) (gp.trueTileS * 1.5), null);
        }
        // hitbox
        g.setColor(Color.white);
        g.fillOval(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
        g.setColor(Color.red);
        g.drawOval(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
        // Balas
        for (int i = 0; i < bullets.size(); i++) {
            g.drawImage(bullets.get(i).image, bullets.get(i).x, bullets.get(i).y, (int) (gp.trueTileS/1.5), (int) (gp.trueTileS/1.5), null);
        }
    }
    private void bounds(){
        while((x-8) < (screenX-150)){
            x++;
            hitbox.x++;
        }
        while((x+24) > (screenX+150)){
            x--;
            hitbox.x--;
        }
        while((y-8) < (screenY-225)){
            y++;
            hitbox.y++;
        }
        while((y+24) > (screenY+225)){
            y--;
            hitbox.y--;
        }
    }
    public void checkEmColl(LivingEntity target){
        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).collidingWith(target) && target.iframes < 0){
                target.lives -= 10;
                target.iframes = 5;
                System.out.println(target.lives);
            }
        }
    }
}
