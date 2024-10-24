package entity.enemies;

import java.awt.Graphics2D;
import java.util.ArrayList;

import entity.LivingEntity;
import main.GamePanel;

public class EnemyManager {
    public ArrayList<Enemy> enemies = new ArrayList<>();
    GamePanel gp;
    public EnemyManager(GamePanel gp){
        this.gp = gp;
    }
    public void addEm(Enemy e){
        enemies.add(e);
    }
    public void draw(Graphics2D g){
        for (int i = 0; i < enemies.size(); i++) {
            g.drawImage(enemies.get(i).image, enemies.get(i).x, enemies.get(i).y, gp.trueTileS, gp.trueTileS, null);
            g.drawRect(enemies.get(i).x, enemies.get(i).y, gp.trueTileS, gp.trueTileS);
        }
    }
    public void update(){
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).update();
            if (enemies.get(i).isOffscreen() || enemies.get(i).lives <= 0){
                enemies.remove(i);
            }
        }
    }
    public void checkEmColl(LivingEntity target){
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).collidingWith(target) && target.iframes < 0){
                target.lives--;
                target.iframes = 15;
                System.out.println(target.lives);
            }
        }
    }
}
