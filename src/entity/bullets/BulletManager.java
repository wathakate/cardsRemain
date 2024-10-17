package entity.bullets;

import main.GamePanel;

import java.awt.*;

public class BulletManager {
    Bullet[] bullets;
    GamePanel gp;
    int spawnX;
    int spawnY;
    public BulletManager(GamePanel gp, int spawnX, int spawnY){
        this.gp = gp;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }
    public void draw(Graphics2D g){
        for (int i = 0; i < bullets.length; i++) {
            g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, gp.trueTileS, gp.trueTileS, null);
        }
    }
    public void update(){
        for (int i = 0; i < bullets.length; i++) {
            bullets[i].y++;
            bullets[i].update();
            if (bullets[i].isOffscreen()){
                bullets[i] = null;
            }
        }
    }
}
