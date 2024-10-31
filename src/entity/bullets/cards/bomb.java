package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class bomb extends SpellCard {
    int x;
    int y;
    int tick = 0;

    public bomb(GamePanel gp, int x, int y) {
        super(gp);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        super.update();
        if (tick == 0){
            patterns.add(new BulletGenerator(gp, x, y, 1, 1, 0, 5, 0, 0, 0, 1));
            patterns.get(patterns.size()-1).dir = 90;
        }
        if (tick == 90){
            patterns.add(new BulletGenerator(gp, x, y, 1, 1, 0, 5, 0, 0, 0, 1));
            patterns.get(patterns.size()-1).dir = 90;
        }
        tick++;

    }
}
