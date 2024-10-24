package stages;

import entity.EnemyManager;
import entity.Player;
import entity.Spade;
import entity.bullets.BulletGenerator;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class stagetest extends Stage{
    BulletGenerator btest;

    public stagetest(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        UI = new UserInterface(gp);
        player = new Player(gp, this,keyH);
        eManager = new EnemyManager(gp);
        btest = new BulletGenerator(gp, 500, 100, 100, 5, 10, 10, 0);

        eManager.addEm(new Spade(gp));
        eManager.enemies.get(0).x = 500;
        eManager.enemies.get(0).y = 100;
    }
    @Override
    public void update(){
        player.update();
        btest.update();
        eManager.update();
        eManager.checkEmColl(player);
        btest.checkBulletColl(player);
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        btest.draw(g2);
        eManager.draw(g2);
        //UI.draw(g2);
    }
}
