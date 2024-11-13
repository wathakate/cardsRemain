package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class tired extends SpellCard {
    int direc = 1;
    public tired(GamePanel gp, Entity parent) {
        super(gp);
        patterns.add(new BulletGenerator(gp, 1, parent.x, parent.y, 30, 4, 2, 5, 0, 25, 0, 1));
        patterns.get(0).dir = -90;
    }
    @Override
    public void update() {
        super.update();
        if (patterns.get(0).dir >= -90){
            direc = -1;
        } else if (patterns.get(0).dir <= -180) {
            direc = 1;
        }
        patterns.get(0).dir += direc*2;
    }
}
