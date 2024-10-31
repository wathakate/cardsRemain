package stages;

import entity.bullets.cards.fourShots;
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
        backColor = Color.CYAN;
        UI = new UserInterface(gp);
        player = new Player(gp,this,keyH);
        eManager = new EnemyManager(gp);
    }
    @Override
    public void update(){
        super.update();
        if (tick == 1){
            eManager.addEm(new Spade(gp, 0, 0), 500, 200);
            System.out.println("a");
        }
        player.update();
        eManager.update();
        eManager.checkEmColl(player);
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
    }
}
