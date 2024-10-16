package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;

public class Player extends Entity{
    public BufferedImage left, right, attack0, attack1, attack2, shoot;
    GamePanel gp;
    KeyHandler keyH;
    public int screenX;
    public int screenY;
    public int spriteNum = 1;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.trueTileS/2);
        screenY = gp.screenHeight/2 - (gp.trueTileS/2);

        hitbox = new Rectangle(28,28,8,8);

        setDefaultValues();
        getImage();
    }
    public void setDefaultValues(){
        x = gp.screenWidth/2 - (gp.trueTileS/2);;
        y = gp.screenHeight/2 - (gp.trueTileS/2);;
        speed = 8;
        sprite = "neutral";
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
        if (keyH.uPressed || keyH.dPressed || keyH.lPressed || keyH.rPressed){
            if (keyH.uPressed){
                y -= speed;
            }
            if (keyH.dPressed){
                y += speed;
            }
            if (keyH.lPressed){
                sprite = "left";
                x -= speed;
            }
            if (keyH.rPressed){
                sprite = "right";
                x += speed;
            }
            if (keyH.ePressed){

            }

        } else{
            sprite = "neutral";
        }
        bounds();
    }
    @Override
    public void draw(Graphics2D g){
        image = null;
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
        g.drawImage(image, x, y, gp.trueTileS, gp.trueTileS, null);

    }
    private void bounds(){
        while((x-16) < screenX-150){
            x++;
        }
        while((x+16) > (screenX+150)){
            x--;
        }
        while((y-16) < (screenY-225)){
            y++;
        }
        while((y+16) > (screenY+225)){
            y--;
        }
    }
}
