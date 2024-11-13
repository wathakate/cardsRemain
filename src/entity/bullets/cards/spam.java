package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class spam extends SpellCard {
    public spam(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp,1, parent.x + 32, parent.y + 32, 20,24, 2,5,0, 15, 0, 1));
    }
}
