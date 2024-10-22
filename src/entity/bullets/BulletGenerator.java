package entity.bullets;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class BulletGenerator {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    // Declarados en instanciacion
    GamePanel gp;
    int spawnX;
    int spawnY;
    int amount;
    int interval;
    int speed;
    int dModifier;
    int curve;
    // No declarados en instanciacion
    int frameInterval;
    int bAmount = 0;
    int dir = 0;

    public BulletGenerator(GamePanel gp, int spawnX, int spawnY, int amount, int interval, int speed, int dModifier, int curve){
        this.gp = gp;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.amount = amount;
        this.interval = interval;
        this.speed = speed;
        this.dModifier = dModifier;

        frameInterval = interval;
    }
    public void draw(Graphics2D g){
        for (int i = 0; i < bullets.size(); i++) {
            g.drawImage(bullets.get(i).image, bullets.get(i).x, bullets.get(i).y, gp.trueTileS, gp.trueTileS, null);
        }
    }
    public void update(){
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update();
            if (bullets.get(i).isOffscreen()){
                bullets.remove(i);
            }
        }
        if (frameInterval == 0 && bAmount < amount){
            bullets.add(new Bullet(gp, spawnX, spawnY, speed, dir));
            bAmount++;
            frameInterval = interval;
        } else {
            frameInterval--;
        }
        dir += dModifier;
    }
}
