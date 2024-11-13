package stages;

import entity.Player;
import entity.enemies.Boss;
import entity.enemies.EnemyManager;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;
import java.io.IOException;

public class Stage06 extends Stage{
    int temp = 0;
    public Stage06(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.BLACK;
        name = "6";
        UI = new UserInterface(gp);
        UI.setUiImage("/res/ui/stage06.png");
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
        if (tick == 120){
            eManager.addEm(new Boss(gp,0, 0), (gp.screenWidth/2)-32,150);
        }
        if (eManager.enemies.isEmpty() && tick > 120){
            temp++;
        }
        if (temp > 500){
            gp.score = 0;
            try {
                gp.stage = new Stage01(gp, keyH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        if (tick > 60 && tick < 120){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g2.drawString("JEFE", (gp.screenWidth/2) - 75, gp.screenHeight/2);
        }
        if (eManager.enemies.isEmpty() && temp > 0){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g2.drawString("GANASTE!!!", (gp.screenWidth/2)-175, gp.screenHeight/2);
        }
    }
}
