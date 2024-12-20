package entity.bullets;

import entity.LivingEntity;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class BulletGenerator {
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    // Declarados en instanciacion
    GamePanel gp;
    public int damage;
    public int spawnX; // Donde en X
    public int spawnY; // Donde en Y
    int amount; // Cantidad de balad
    int amPerCycle; // La cantidad de balas que se disparan al mismo tiempo
    int interval; // Cuantos frames tarda en disparar otra vez
    int speed; // Velocidad de las valas
    int dModifier; // Cuanto cambia de angulo del BulletGenerator
    int perBlMod; //Complicado de explicar, revise update
    float curve; // Cuanto cambia el angulo de las balas
    int type;

    // No declarados en instanciacion
    int frameInterval;
    int bAmount = 0;
    public int dir = 0;

    public BulletGenerator(GamePanel gp,int damage,int spawnX, int spawnY, int amount, int amPerCycle, int interval, int speed, int dModifier, int perBlMod,float curve, int type){
        this.gp = gp;
        this.damage = damage;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.amount = amount;
        this.amPerCycle = amPerCycle;
        this.interval = interval;
        this.speed = speed;
        this.dModifier = dModifier;
        this.perBlMod = perBlMod;
        this.curve = curve;
        this.type = type;

        frameInterval = interval;
    }
    public void draw(Graphics2D g){
        for (int i = 0; i < bullets.size(); i++) {
            g.drawImage(bullets.get(i).image, bullets.get(i).x, bullets.get(i).y, (int) (gp.trueTileS/1.5), (int) (gp.trueTileS/1.5), null);
            //g.drawRect(bullets.get(i).hitbox.x, bullets.get(i).hitbox.y, bullets.get(i).hitbox.width, bullets.get(i).hitbox.height);
            //bullets.get(i).draw(g);
        }
    }
    public void update(){
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).direction += (int) curve;
            bullets.get(i).update();
            if (bullets.get(i).isOffscreen()){
                bullets.remove(i);
            }
        }
        if (frameInterval == 0 && bAmount < amount){
            int blDir = dir;
            for (int i = 0; i < amPerCycle; i++) {
                bullets.add(new Bullet(gp, spawnX, spawnY, speed, blDir, type));
                blDir += perBlMod;
            }
            bAmount++;
            frameInterval = interval;
        } else {
            frameInterval--;
        }
        dir += dModifier;
    }
    public void checkBulletColl(LivingEntity target){
        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).collidingWith(target) && target.iframes < 0){
                target.lives -= damage;
                target.iframes = 15;
            }
        }
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}

