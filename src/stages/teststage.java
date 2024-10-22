package stages;

import entity.EnemyManager;
import entity.Player;
import entity.Spade;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class teststage extends Stage{
    EnemyManager eManager;

    public teststage(GamePanel gp) {
        super(gp);
        eManager = new EnemyManager(gp);
        eManager.addEm(new Spade(gp));
        eManager.enemies.get(0).x = 500;
        eManager.enemies.get(0).y = 200;
    }
    @Override
    public void update(){
        player.update();
        eManager.update(player);
    }
    @Override
    public void draw(Graphics2D g2){
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        g2.dispose();
    }
}
