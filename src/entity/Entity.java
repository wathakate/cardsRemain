package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.Math.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Entity {
    public int x, y;
    public int speed;
    public int direction;
    float dirX;
    float dirY;
    
    public BufferedImage image;
    public BufferedImage neutral;
    public String sprite;
    public Rectangle hitbox;
    public boolean collTrue = false;
    GamePanel gp;
    
    public void getImage(String l){
        try{
            image = ImageIO.read(getClass().getResourceAsStream(l));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        dirX = xDir(direction);
        dirX = yDir(direction);
    }
    public void draw(Graphics2D g){
        g.drawImage(image, x, y, gp.trueTileS, gp.trueTileS, null);

    }

    static float xDir(int angle) {
        float radians = (float) (angle * PI / 180.0);
        return (float) cos(radians);
    }
    static float yDir(int angle) {
        float radians = (float) (angle * PI / 180.0);
        return (float) -sin(radians);

    }

    public boolean isOffscreen(){
        if ((x) < (496-150) || (x) > (496+150)){
            return true;
        }
        else if ((y) < (0) || (y) > (272+225)){
            return true;
        }
        else{
            return false;
        }
    }
}
