package entity.bullets;

import entity.LivingEntity;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class SpellCard {
    public ArrayList<BulletGenerator> patterns = new ArrayList<>();
    boolean finished;
    public GamePanel gp;

    public SpellCard(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g){
        for (int i = 0; i < patterns.size(); i++) {
            patterns.get(i).update();
        }

    }
    public void update(){
        for (int i = 0; i < patterns.size(); i++) {
            patterns.get(i).update();
        }

    }
    public void checkBullColl(LivingEntity target){
        for (int i = 0; i < patterns.size(); i++) {
            patterns.get(i).checkBulletColl(target);
        }
    }
    public boolean isFinished(){
        if (finished){
            patterns.clear();
        }
        return finished;
    }
}
