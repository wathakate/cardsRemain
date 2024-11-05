package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class summons extends SpellCard {
    Entity parent;
    public summons(GamePanel gp, Entity parent) {
        super(gp);
        this.parent = parent;
        // "amigos"
        patterns.add(new BulletGenerator(gp, 5, parent.x + 64, parent.y, 90, 1, 0, 0, 0 ,0, 1, 1));
        patterns.add(new BulletGenerator(gp, 5, parent.x - 32, parent.y, 90, 1, 0, 0, 0 ,0, 1, 1));
        // las balas en si
        patterns.add(new BulletGenerator(gp, 5, parent.x + 32, parent.y + 16,20, 1, 3, 10, 0, 0, 0, 0 ));
        patterns.add(new BulletGenerator(gp, 5, parent.x - 16, parent.y + 16,20, 1, 3, 10, 0, 0, 0, 0 ));
        patterns.get(2).dir = 90;
        patterns.get(3).dir = 90;
    }
    @Override
    public void update() {
        // los "amigos"
        patterns.get(0).getBullets().clear();
        patterns.get(1).getBullets().clear();
        patterns.get(0).spawnX = parent.x + 32;
        patterns.get(1).spawnX = parent.x - 16;
        patterns.get(0).spawnY = parent.y + 16;
        patterns.get(1).spawnY = parent.y + 16;
        // las balas
        patterns.get(2).spawnX = parent.x + 32;
        patterns.get(3).spawnX = parent.x - 16;
        patterns.get(2).spawnY = parent.y + 16;
        patterns.get(3).spawnY = parent.y + 16;
        super.update();

    }
}
