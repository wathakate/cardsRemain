package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class fourShots extends SpellCard {
    int x;
    int y;

    public fourShots(GamePanel gp, int x, int y) {
        super(gp);
        this.x = x;
        this.y = y;
        patterns.add(new BulletGenerator(gp, 1,x, y, 4, 1, 5, 5, 0, 0, 0, 1));
        patterns.get(patterns.size()-1).dir = -90;
    }

    @Override
    public void update() {
        super.update();

    }
}
