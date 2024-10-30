package entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import static java.lang.Math.*;
import javax.imageio.ImageIO;
import main.GamePanel;

public class Entity {
    public int x, y;
    public int speed;
    public int direction;
    public float dirX;
    public float dirY;
    
    public BufferedImage image;
    public BufferedImage neutral;
    public String sprite;
    public Rectangle hitbox;
    public boolean collTrue = false;
    GamePanel gp;
    
    public void setImage(String l){
        try{
            image = ImageIO.read(getClass().getResourceAsStream(l));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void update(){
        dirX = xDir(direction);
        dirY = yDir(direction);
    }
    public void draw(Graphics2D g){
        g.drawImage(image, x, y, 32, 32, null);
    }

    static float xDir(int angle) {
        float radians = (float) ((float)angle * PI / 180.0);
        return (float) cos(radians);
    }
    static float yDir(int angle) {
        float radians = (float) ((float)angle * PI / 180.0);
        return (float) -sin(radians);

    }

    public boolean collidingWith(LivingEntity target) {
        return hitbox.intersects(target.hitbox);
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
