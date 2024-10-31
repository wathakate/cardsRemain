package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import entity.bullets.Bullet;
import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.bombDef;
import entity.bullets.cards.fourShotsDef;
import main.GamePanel;
import main.KeyHandler;
import stages.Stage;

import javax.imageio.ImageIO;

public class Player extends LivingEntity{
    public BufferedImage left, right, attack0, attack1, attack2, shoot;
    GamePanel gp;
    KeyHandler keyH;
    Random ran = new Random();
    Stage stage;
    public int screenX;
    public int screenY;
    final int MAXLIVES = 5;

    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    int cooldown = 0;
    int cardCooldown = 0;
    int selection = 0;

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
        //temp
        setCards();
        sp[0] = new bombDef(gp, this);
        sp[1] = new fourShotsDef(gp, this);
    }
    public void setCards(){

        sp = new CardDefinition[3];
        /*for (int i = 0; i < 3; i++) {
            cardCase(i);
        }*/
    }
    public void cardCase(int i){
        switch (ran.nextInt(10)){
            case 0:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 1:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 2:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 3:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 4:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 5:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 6:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 7:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 8:
                sp[i] = new CardDefinition(gp, this);
                break;
            case 9:
                sp[i] = new CardDefinition(gp, this);
                break;
        }
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

        } else{
            sprite = "neutral";
        }
        if (keyH.shotPressed || keyH.lSelection || keyH.rSelection || keyH.scPressed){
            if (keyH.shotPressed && cooldown <= 0){
                bullets.add(new Bullet(gp,x, y, 10, 90, 0));
                cooldown = 5;
            }
            if (keyH.lSelection){
                if (selection > 0){
                    selection--;
                    System.out.println( selection);
                }
            }
            if (keyH.rSelection){
                if (selection < 2){
                    selection++;
                    System.out.println(selection);
                }
            }
            if (keyH.scPressed && cardCooldown <= 0){
                drawnCards.add(sp[selection].drawCard());
                cardCooldown = 60;
            }
        }
        speed = 8;
        cooldown--;
        cardCooldown--;
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
        for (int i = 0; i < drawnCards.size(); i++) {
            drawnCards.get(i).update();
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
        for (int i = 0; i < drawnCards.size(); i++) {
            drawnCards.get(i).draw(g);
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
            if ((bullets.get(i).collidingWith(target) ) && target.iframes < 0){
                target.lives -= 10;
                target.iframes = 5;
            }
        }
        if (!drawnCards.isEmpty()) {
            for (int i = 0, originalHp = target.lives; i < drawnCards.size(); i++) {
                drawnCards.get(i).checkBullColl(target);
                if (target.lives < originalHp){
                    target.iframes = 5;
                }
            }
        }
    }
}
