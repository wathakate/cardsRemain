package stages;

import entity.Player;
import entity.enemies.Diamond;
import entity.enemies.EnemyManager;
import entity.enemies.Hearth;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class Stage03 extends Stage{
    public Stage03(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.pink;
        name = "3";
        UI = new UserInterface(gp);
        UI.setUiImage("/res/ui/stage03.png");
        player = new Player(gp,this,keyH);
        eManager = new EnemyManager(gp);
        gp.saveProgress(gp.score, Integer.parseInt(name));
        gp.updatePanel(backColor);
    }

    @Override
    public void update() {
        super.update();
        super.update();
        player.update();
        eManager.update();
        eManager.checkEmColl(player);
        if (tick == 60){
            eManager.addEm(new Hearth(gp, 0, 2), (gp.screenWidth/2) - 16,50);
        }
        if (tick == 320){
            eManager.addEm(new Hearth(gp, 2, 0), 350,150);
            eManager.addEm(new Hearth(gp, -2, 0), 625,150);
        }
        if (tick == 400){
            eManager.addEm(new Hearth(gp, 1, 2), (gp.screenWidth/2) - 16,50);
            eManager.addEm(new Hearth(gp, -1, 2), (gp.screenWidth/2) - 16,50);
        }
        if (tick == 480){
            eManager.addEm(new Hearth(gp, 2, 0), 350,200);
            eManager.addEm(new Hearth(gp, -3, 0), 625,300);
        }
        if (tick == 560){
            eManager.addEm(new Hearth(gp, 3, 0), 350,300);
            eManager.addEm(new Hearth(gp, -2, 0), 625,200);
        }
        if (tick == 700){
            eManager.addEm(new Hearth(gp, 0, 0), (gp.screenWidth/2) - 16,100);

        }
        if (tick == 2000){
            gp.stage = new Stage04(gp, keyH);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        if (tick >= 1750 && tick < 2000){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g2.drawString("COMPLETADO", (gp.screenWidth/2)-175, gp.screenHeight/2);
        }
    }
}
