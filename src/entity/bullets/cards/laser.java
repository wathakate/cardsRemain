package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class laser extends SpellCard {
    public laser(GamePanel gp, int x, int y) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 15, x, y, 25, 1, 0, 20, 0, 0, 0, 0));
        patterns.get(0).dir = -90;
    }

    @Override
    public void update() {
        super.update();
    }
}
