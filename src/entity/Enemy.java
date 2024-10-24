package entity;

import main.GamePanel;

import java.awt.*;

public class Enemy extends Entity{
    GamePanel gp;
    String sprite;
    
    public Enemy(GamePanel gp){
        this.gp = gp;
        lives = 50;
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/testEm.png");
    }

    @Override
    public void update() {
        super.update();
        hitbox.x = x;
        hitbox.y = y;
    }
}
