package entity.bullets.cards;

import entity.Entity;
import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class sideShot extends SpellCard {
    int tick = 0;
    int x;
    int y;
    Entity parent;

    public sideShot(GamePanel gp, int x, int y, Entity parent) {
        super(gp);
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
    @Override
    public void update(){
        super.update();
        x = parent.x;
        y = parent.y;
        if (tick == 0){
            patterns.add(new BulletGenerator(gp, 15, x, y,1, 2, 0, 5, 0, 180, 0, 0 ));
        }
        if (tick == 5){
            patterns.add(new BulletGenerator(gp, 15, x, y,1, 2, 0, 5, 0, 180, 0, 0 ));
        }
        if (tick == 10){
            patterns.add(new BulletGenerator(gp, 15, x, y,1, 2, 0, 5, 0, 180, 0, 0 ));
        }
        if (tick == 15){
            patterns.add(new BulletGenerator(gp, 15, x, y,1, 2, 0, 5, 0, 180, 0, 0 ));
        }
        tick++;
    }
}
