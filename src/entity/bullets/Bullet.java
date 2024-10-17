package entity.bullets;

import entity.Entity;
import main.GamePanel;

public class Bullet extends Entity {
    GamePanel gp;

    public Bullet(GamePanel gp, int x, int y, int speed) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.speed = speed;
        setImage("/res/enemy/testEm.png");
    }

    @Override
    public void update() {
        super.update();
        y+=speed;
    }
}
