package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class cloverPattern extends SpellCard {
    public cloverPattern(GamePanel gp, int x, int y) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, x + 8, y + 8, 1, 8, 0, 3, 0, 45, 1, 1));
    }
}
