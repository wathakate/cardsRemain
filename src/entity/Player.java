package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public int screenX;
    public int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.trueTileS/2);
        screenY = gp.screenHeight/2 - (gp.trueTileS/2);

        hitbox = new Rectangle(8,8,32,32);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.uPressed || keyH.dPressed || keyH.lPressed || keyH.rPressed){
            if (keyH.uPressed){
                direction = "up";
                y -= speed;
            }
            if (keyH.dPressed){
                direction = "down";
                y += speed;
            }
            if (keyH.lPressed){
                direction = "left";
                x -= speed;
            }
            if (keyH.rPressed){
                direction = "right";
                x += speed;
            }
            if (keyH.ePressed){

            }
            collTrue = false;

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else{
            spriteNum = 1;
        }

    }
    public void draw(Graphics2D g){
        BufferedImage image = null;
        switch (direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }else if (spriteNum ==2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum ==2) {
                    image = down2;
                }

                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum ==2) {
                    image = left2;
                }

                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum ==2) {
                    image = right2;
                }

                break;
        }
        g.drawImage(image, x, y, gp.trueTileS, gp.trueTileS, null);

    }
}
