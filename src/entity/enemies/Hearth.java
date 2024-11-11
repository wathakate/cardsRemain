package entity.enemies;

import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.diamondDef;
import entity.bullets.cards.hearthDef;
import main.GamePanel;

import java.awt.*;

public class Hearth extends Enemy{
    public Hearth(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        lives = 50;
        scoreGiven = 30;
        cooldown = 90;
        collTrue = true;
        sp = new CardDefinition[1];
        sp[0] = new hearthDef(gp, this);
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/hearth.png");
    }

    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown < 0){
            drawnCards.add(sp[0].drawCard());
            cooldown = 90;
        }
    }
}
