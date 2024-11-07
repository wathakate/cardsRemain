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
    int speedX;
    int speedY;
    
    public Enemy(GamePanel gp, int speedX, int speedY){
        this.gp = gp;
        this.speedX = speedX;
        this.speedY = speedY;
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
        x += speedX;
        y += speedY;
        hitbox.x = x;
        hitbox.y = y;
    }
    public void checkColl(LivingEntity target){
        if (!drawnCards.isEmpty()) {
            for (int i = 0, originalHp = target.lives; i < drawnCards.size(); i++) {
                drawnCards.get(i).checkBullColl(target);
                if (target.lives < originalHp){
                    target.iframes = 5;
                }
            }
        }
    }
}
