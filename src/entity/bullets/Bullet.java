package entity.bullets;

import entity.Entity;
import main.GamePanel;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bullet extends Entity {
    GamePanel gp;

    public Bullet(GamePanel gp, int x, int y, int speed, int direction, int type) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        hitbox = new Rectangle(x + 6,y + 6, gp.trueTileS / 2, gp.trueTileS / 2);
        switch (type){
            case 1:
                setImage("/res/enemy/bullet_01.png");
                break;
            case 2:
                setImage("/res/enemy/bullet_02.png");
                break;
            case 3:
                setImage("/res/enemy/bullet_03.png");
                break;
            case 4:
                setImage("/res/enemy/bullet_04.png");
                break;
            case 0:
                setImage("/res/enemy/bullet_card.png");
                break;
        }
    }

    @Override
    public void update() {
        super.update();
        x = (int) (x + dirX * speed);
        y = (int) (y + dirY * speed);
        hitbox.x = x + 6;
        hitbox.y = y + 16;
    }

    @Override
    public void draw(Graphics2D g) {
        /* por ChatGPT, capaz que lo arreglo nose
        AffineTransform oldTransform = g.getTransform();
        g.translate(x + 16, y + 16);
        g.rotate(direction);
        g.drawImage(image, -16, -16, 21, 21, null);
        g.setTransform(oldTransform);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);*/
    }
}
