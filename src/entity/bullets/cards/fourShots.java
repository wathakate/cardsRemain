package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class fourShots extends SpellCard {
    int cooldown = 0;
    int x;
    int y;

    public fourShots(GamePanel gp) {
        super(gp);
    }

    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown <= 0){
            patterns.add(new BulletGenerator(gp, x, y, 4, 1, 1, 5, 0, 0, 0, 1));
            patterns.get(patterns.size()-1).dir = -90;
            cooldown = 1;
        }
    }
}
