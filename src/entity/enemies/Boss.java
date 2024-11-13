package entity.enemies;

import entity.bullets.cards.*;
import main.GamePanel;
import java.awt.*;
import java.util.Random;

public class Boss extends Enemy{
    int tick = 0;
    Random ran = new Random();
    public Boss(GamePanel gp, int speedX, int speedY) {
        super(gp, speedX, speedY);
        lives = 1500;
        scoreGiven = 420;
        collTrue = true;
        sp = new CardDefinition[6];
        sp[0] = new cloverDef(gp, this);
        sp[1] = new spamDef(gp,this);
        sp[2] = new dCycleDef(gp,this);
        sp[3] = new tiredDef(gp,this);
        sp[4] = new emLaserDef(gp,this);
        hitbox = new Rectangle(x, y, gp.trueTileS*2, gp.trueTileS*2);
        setImage("/res/enemy/testEm.png");
    }

    @Override
    public void update() {
        super.update();
        tick++;
        if (tick == 100){
            drawnCards.add(sp[0].drawCard());
        }
        if (tick == 110){
            drawnCards.add(sp[0].drawCard());
        }
        if (tick == 120){
            drawnCards.add(sp[0].drawCard());
        }
        if (tick == 130){
            drawnCards.add(sp[0].drawCard());
        }
        if (tick == 140){
            drawnCards.add(sp[0].drawCard());
        }
        if (tick % 90 == 0){
            drawnCards.add(sp[ran.nextInt(5)].drawCard());
        }
        if (lives < 1000 && tick % 30 == 0){
            // No logro entender porque (int)Math.sin(tick)*10 da 0
            //speedX = (int) Math.sin(tick)*10;
            //speedY = (int) Math.sin(tick)*10;
            drawnCards.add(sp[0].drawCard());
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(image, x, y, 64, 64, null);
        for (int i = 0; i < drawnCards.size(); i++) {
            drawnCards.get(i).draw(g);
        }
        g.fillRect(330, 50, lives/4, 15);
    }
}
