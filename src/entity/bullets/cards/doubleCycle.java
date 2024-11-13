package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

import java.util.Random;

public class doubleCycle extends SpellCard {
    public doubleCycle(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, parent.x + 32, parent.y + 32, 20, 8, 2, 3, 13, 47, 0, 1));
        patterns.get(0).dir = new Random().nextInt(360);
        patterns.add(new BulletGenerator(gp, 1, parent.x + 32, parent.y + 32, 20, 8, 4, 5, -17, 43, 0, 1));
        patterns.get(1).dir = new Random().nextInt(360);
    }
}
