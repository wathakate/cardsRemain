package entity.enemies;

import entity.LivingEntity;
import entity.bullets.BulletGenerator;
import entity.bullets.cards.cardDefinition;
import entity.bullets.cards.fourShots;
import entity.bullets.cards.fourShotsDef;
import main.GamePanel;
import java.awt.*;
import java.util.ArrayList;

public class Spade extends Enemy{
    int cooldown = 0;
    ArrayList<BulletGenerator> temp = new ArrayList<>();
    public Spade(GamePanel gp) {
        super(gp);
        speed = 0;
        lives = 30;
        scoreGiven = 15;
        collTrue = true;
        sp = new cardDefinition[1];
        sp[0] = new fourShotsDef(gp, x, y);
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
    }

    @Override
    public void update() {
        super.update();
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).update();
        }
        y += speed;
        cooldown--;
        if (cooldown <= 0){
            temp.add(new BulletGenerator(gp, x, y, 4, 1, 5, 5, 0, 0, 0, 1));
            temp.get(temp.size()-1).dir = -90;
            cooldown = 60;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).draw(g);
        }
    }
    public void bullCollWith(LivingEntity target){
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).checkBulletColl(target);
        }
    }
}
