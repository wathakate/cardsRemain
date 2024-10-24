package entity.bullets;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class Bullet extends Entity {
    GamePanel gp;

    public Bullet(GamePanel gp, int x, int y, int speed, int direction) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        hitbox = new Rectangle(x,y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/testEm.png");
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
