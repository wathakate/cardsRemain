package entity.bullets.cards;

import entity.bullets.BulletGenerator;
import entity.bullets.SpellCard;
import main.GamePanel;

public class bomb extends SpellCard {
    int x;
    int y;
    int bombX;
    int bombY;
    int tick = 0;

    public bomb(GamePanel gp, int x, int y) {
        super(gp);
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        super.update();
        if (bombX != 0){
            bombY -= 3;
        }
        if (tick == 0){
            patterns.add(new BulletGenerator(gp, 30,x, y, 1, 1, 0, 3, 0, 0, 0, 3));
            patterns.get(patterns.size()-1).dir = 90;
            bombX = x;
            bombY = y;
        }
        if (tick == 60){
            patterns.remove(0);
            patterns.add(new BulletGenerator(gp, 10,bombX, bombY, 4, 16, 5, 5, 10, 22, 0, 3));
            patterns.get(patterns.size()-1).dir = 90;
        }
        tick++;
    }
}
