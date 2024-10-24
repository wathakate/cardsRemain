package entity;

import main.GamePanel;

import java.awt.*;

public class Spade extends Enemy{
    public Spade(GamePanel gp) {
        super(gp);
        speed = 2;
        collTrue = true;
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
    }

    @Override
    public void update() {
        super.update();
        y += speed;
    }
}
