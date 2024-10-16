package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Enemy extends Entity{
    int hp;
    GamePanel gp;
    String sprite;
    
    public Enemy(GamePanel gp){
        this.gp = gp;
        getImage("/res/enemy/neutral.png");
    }
    
}
