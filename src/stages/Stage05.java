package stages;

import entity.Player;
import entity.enemies.EnemyManager;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class Stage05 extends Stage{
    public Stage05(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.BLACK;
        name = "5";
        UI = new UserInterface(gp);
        player = new Player(gp,this,keyH);
        eManager = new EnemyManager(gp);
        gp.saveProgress(gp.score, Integer.parseInt(name));
        gp.updatePanel(backColor);
    }

    @Override
    public void update() {
        super.update();
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
