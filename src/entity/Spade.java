package entity;

import main.GamePanel;

public class Spade extends Enemy{
    public Spade(GamePanel gp) {
        super(gp);
        speed = 2;
    }

    public void update() {
        super.update();
        y += speed;
    }
}
