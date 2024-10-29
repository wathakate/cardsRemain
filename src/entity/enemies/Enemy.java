package entity.enemies;

import entity.LivingEntity;
import entity.bullets.SpellCard;
import entity.bullets.cards.fourShots;
import main.GamePanel;

import java.awt.*;

public class Enemy extends LivingEntity {
    GamePanel gp;
    String sprite;
    int cooldown;
    int scoreGiven;
    
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
