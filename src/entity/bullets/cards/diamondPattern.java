package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class diamondPattern extends SpellCard {
    public diamondPattern(GamePanel gp, int x, int y) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, x, y, 1, 4, 0, 2, 0, 90, 0, 2));
    }
}
