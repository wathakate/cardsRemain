package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class tripleShot extends SpellCard {
    Entity parent;
    public tripleShot(GamePanel gp, Entity parent) {
        super(gp);
        this.parent = parent;

        patterns.add(new BulletGenerator(gp,5, parent.x + 16, parent.y, 5, 3, 2, 5,0,30, 0, 0));
        patterns.get(0).dir = 60;
    }

    @Override
    public void update() {
        patterns.get(0).spawnX = parent.x + 16;
        patterns.get(0).spawnY = parent.y;
        super.update();
    }
}
