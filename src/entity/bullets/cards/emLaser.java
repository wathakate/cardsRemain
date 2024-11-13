package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class emLaser extends SpellCard {
    int direc = 1;
    public emLaser(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, parent.x, parent.y, 30, 1, 8, 5, 0, 0, 0, 1));
        patterns.get(0).dir = -90;
    }
    @Override
    public void update() {
        super.update();
        if (patterns.get(0).spawnX >= 548){
            direc = -1;
        } else if (patterns.get(0).spawnX <= 480) {
            direc = 1;
        }
        patterns.get(0).spawnX += direc;
    }
}
