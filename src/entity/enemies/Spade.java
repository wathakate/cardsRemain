package entity.enemies;

import entity.bullets.BulletGenerator;
import entity.bullets.cards.fourShots;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class Spade extends Enemy{
    ArrayList<BulletGenerator> balas = new ArrayList<>();
    int cooldown = 0;

    public Spade(GamePanel gp) {
        super(gp);
        speed = 0;
        lives = 30;
        scoreGiven = 15;
        collTrue = true;
        hitbox = new Rectangle(x, y, gp.trueTileS, gp.trueTileS);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).draw(g);
        }
    }

    @Override
    public void update() {
        super.update();
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).update();
        }
        y += speed;
        cooldown--;
        if (cooldown <= 0){
            balas.add(new BulletGenerator(gp, x, y, 4, 1, 1, 5, 0, 0, 0, 1));
            balas.get(balas.size()-1).dir = -90;
            cooldown = 60;
        }
    }
}
