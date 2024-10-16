package entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
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
        }
    }
}
