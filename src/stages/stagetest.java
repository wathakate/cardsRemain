package stages;

import entity.enemies.EnemyManager;
import entity.Player;
import entity.enemies.Spade;
import entity.bullets.BulletGenerator;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;
import java.util.ArrayList;

public class stagetest extends Stage{
    public stagetest(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        UI = new UserInterface(gp);
        player = new Player(gp, this,keyH);
        eManager = new EnemyManager(gp);
        eManager.addEm(new Spade(gp));
        eManager.enemies.get(0).x = 500;
        eManager.enemies.get(0).y = 200;
    }
    @Override
    public void update(){
        player.update();
        eManager.update();
        eManager.checkEmColl(player);
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        //UI.draw(g2);
    }
}
