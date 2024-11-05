package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class doubleCurved extends SpellCard {
    public doubleCurved(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 5, parent.x, parent.y, 8, 1, 4, 5, 0, 0, 1, 1));
        patterns.get(0).dir = 45;
        patterns.add(new BulletGenerator(gp, 5, parent.x, parent.y, 8, 1, 4, 5, 0, 0, -1, 1));
        patterns.get(1).dir = 135;
    }
}
