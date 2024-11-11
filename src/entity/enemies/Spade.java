package entity.enemies;

import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.fourShotsDef;
import main.GamePanel;
import java.awt.*;

public class Spade extends Enemy{
    public Spade(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        lives = 30;
        scoreGiven = 15;
        collTrue = true;
        sp = new CardDefinition[1];
        sp[0] = new fourShotsDef(gp, this);
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/spade.png");
    }

    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown <= 0){
            drawnCards.add(sp[0].drawCard());
            cooldown = 60;
        }
    }
}
