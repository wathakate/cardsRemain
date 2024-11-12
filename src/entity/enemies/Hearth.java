package entity.enemies;

import entity.bullets.cards.CardDefinition;
import entity.bullets.cards.diamondDef;
import entity.bullets.cards.hearthDef;
import main.GamePanel;

import java.awt.*;

public class Hearth extends Enemy{
    public Hearth(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        lives = 30;
        scoreGiven = 30;
        cooldown = 30;
        collTrue = true;
        sp = new CardDefinition[1];
        sp[0] = new hearthDef(gp, this);
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
        setImage("/res/enemy/hearth.png");
    }
    int originalSpeedX = speedX;
    int originalSpeedY = speedY;
    @Override
    public void update() {
        super.update();
        cooldown--;
        if (cooldown < 50){
            speedX = originalSpeedX;
            speedY = originalSpeedY;
        }
        if (cooldown < 0){
            drawnCards.add(sp[0].drawCard());
            cooldown = 120;
            speedX = 0;
            speedY = 0;
        }
    }
}
