package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class hearthPattern extends SpellCard {
    int direc = 1;

    public hearthPattern(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, parent.x, parent.y, 15, 1, 2, 5, 0, 0, 0, 1));
        patterns.get(0).dir = -90;
    }

    @Override
    public void update() {
        super.update();
        if (patterns.get(0).dir >= -45){
            direc = -1;
        } else if (patterns.get(0).dir <= -135) {
            direc = 1;
        }
        patterns.get(0).dir += direc*3;
    }
}
