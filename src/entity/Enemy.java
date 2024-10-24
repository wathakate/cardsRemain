package entity;

import entity.bullets.SpellCard;
import main.GamePanel;

import java.awt.*;

public class Enemy extends Entity{
    GamePanel gp;
    String sprite;
    int scoreGiven;
    SpellCard[] sp;
    
    public Enemy(GamePanel gp){
        this.gp = gp;
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/testEm.png");
    }

    @Override
    public void update() {
        super.update();
        if (lives <= 0){
            gp.score += scoreGiven;
            System.out.println(gp.score);
        }
        hitbox.x = x;
        hitbox.y = y;
    }
}
