package entity.enemies;

import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.diamondDef;
import main.GamePanel;

import java.awt.*;

public class Diamond extends Enemy{
    public Diamond(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        lives = 100;
        scoreGiven = 30;
        cooldown = 30;
        collTrue = true;
        sp = new CardDefinition[1];
        sp[0] = new diamondDef(gp, this);
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
    }

    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown < 0){
            drawnCards.add(sp[0].drawCard());
            cooldown = 30;
        }
    }
}
