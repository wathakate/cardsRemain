package entity.bullets;

import entity.LivingEntity;

import java.awt.*;

public class SpellCard {
    BulletGenerator[] patterns;

    public void draw(Graphics2D g){
        for (int i = 0; i < patterns.length; i++) {
            patterns[i].draw(g);
        }
    }
    public void update(){
        for (int i = 0; i < patterns.length; i++) {
            patterns[i].update();
        }
    }
    public void checkBullColl(LivingEntity target){
        for (int i = 0; i < patterns.length; i++) {
            patterns[i].checkBulletColl(target);
        }
    }
}
