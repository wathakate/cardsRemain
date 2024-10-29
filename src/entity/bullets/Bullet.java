package entity.bullets;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class Bullet extends Entity {
    GamePanel gp;

    public Bullet(GamePanel gp, int x, int y, int speed, int direction, int type) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        hitbox = new Rectangle(x,y, gp.trueTileS, gp.trueTileS);
        switch (type){
            case 1:
                setImage("/res/enemy/bullet_01.png");
                break;
            case 2:
                setImage("/res/enemy/bullet_02.png");
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
        hitbox.x = x;
        hitbox.y = y;
    }
}
