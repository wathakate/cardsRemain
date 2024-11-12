package entity.enemies;

import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.cloverDef;
import entity.bullets.cards.fourShotsDef;
import main.GamePanel;

import java.awt.*;

public class Clover extends Enemy{
    public Clover(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        setImage("/res/enemy/testEm.png");
        lives = 60;
        scoreGiven = 25;
        collTrue = true;
        sp = new CardDefinition[1];
        sp[0] = new cloverDef(gp, this);
        cooldown = 0;
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
    }

    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown <= 0){
            drawnCards.add(sp[0].drawCard());
            cooldown = 10;
            lives--;
        }
    }
}
