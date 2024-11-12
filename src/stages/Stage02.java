package stages;

import entity.Player;
import entity.enemies.Diamond;
import entity.enemies.EnemyManager;
import entity.enemies.Spade;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class Stage02 extends Stage{
    public Stage02(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.CYAN;
        name = "2";
        UI = new UserInterface(gp);
        UI.setUiImage("/res/ui/testui.png");
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
        if (tick == 60){
            eManager.addEm(new Diamond(gp, 0, 1), gp.screenWidth/2,50);
        }
        if (tick == 300){
            eManager.addEm(new Diamond(gp, 0, 2),400,50);
            eManager.addEm(new Diamond(gp, 0, 2),600,50);
        }
        if (tick == 600){
            eManager.addEm(new Diamond(gp, 2, 2),350,100);
            eManager.addEm(new Diamond(gp, -2, 2),625,100);
            eManager.addEm(new Diamond(gp, 2, -2),350,400);
            eManager.addEm(new Diamond(gp, -2, -2),625,400);
        }
        if (tick == 700){
            eManager.addEm(new Diamond(gp, 2, 0),350,284);
            eManager.addEm(new Diamond(gp, -2, 0),625,284);
            eManager.addEm(new Diamond(gp, 0, 3),496,50);
            eManager.addEm(new Diamond(gp, 0, -3),496,475);
        }
        if (tick == 800){
            eManager.addEm(new Diamond(gp, 2, 3),496,284);
            eManager.addEm(new Diamond(gp, -2, 3),496,284);
            eManager.addEm(new Diamond(gp, 2, -3),496,284);
            eManager.addEm(new Diamond(gp, -2, -3),496,284);
        }
        if (tick == 900){
            eManager.addEm(new Diamond(gp, 2, 3),350,284);
            eManager.addEm(new Diamond(gp, -2, 3),625,284);
            eManager.addEm(new Diamond(gp, 2, -3),350,284);
            eManager.addEm(new Diamond(gp, -2, -3),625,284);
        }
        if (tick == 1250){
            gp.stage = new Stage03(gp, keyH);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        if (tick >= 1000 && tick < 1250){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g2.drawString("COMPLETADO", (gp.screenWidth/2)-175, gp.screenHeight/2);
        }
    }
}
