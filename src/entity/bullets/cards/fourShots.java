package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class fourShots extends SpellCard {
    Entity parent;

    public fourShots(GamePanel gp, Entity parent) {
        super(gp);
        this.parent = parent;
        patterns.add(new BulletGenerator(gp, 1, parent.x, parent.y + 32, 4, 1, 5, 5, 0, 0, 0, 1));
        patterns.get(patterns.size()-1).dir = -90;
    }

    @Override
    public void update() {
        patterns.get(0).spawnX = parent.x;
        patterns.get(0).spawnY = parent.y + 32;
        super.update();
    }
}
