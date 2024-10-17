package entity.bullets;

import entity.Entity;
import main.GamePanel;

public class Bullet extends Entity {
    GamePanel gp;

    public Bullet(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void update() {
        super.update();
    }
}
