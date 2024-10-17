package entity.bullets;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class BulletManager {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    GamePanel gp;
    int spawnX;
    int spawnY;
    int interval;
    int speed;
    int dModifier;
    int frameInterval;
    int bAmount = 0;

    public BulletManager(GamePanel gp, int spawnX, int spawnY, int amount, int interval, int speed, int dModifier){
        this.gp = gp;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
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
        }
        if (frameInterval == 0){
            bullets.add(new Bullet(gp, spawnX, spawnY, speed));
            frameInterval = interval;
        } else {
            frameInterval--;
        }
    }
}
