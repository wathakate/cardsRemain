package stages;

import entity.Player;
import entity.enemies.*;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Stage05 extends Stage{
    public Stage05(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.DARK_GRAY;
        name = "5";
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
            eManager.addEm(new Spade(gp, 0, 2),gp.screenWidth/2,50);
        }
        if (tick == 160){
            eManager.addEm(new Diamond(gp, 0, 2),400,50);
            eManager.addEm(new Clover(gp, 0, 2),600,50);
        }
        if (tick == 230){
            eManager.addEm(new Hearth(gp, 0, 0),gp.screenWidth/2,150);
        }
        if (tick == 360){
            eManager.addEm(new Spade(gp, 2, 3),400,50);
            eManager.addEm(new Spade(gp, -2, 3),600,50);
        }
        if (tick == 380){
            eManager.addEm(new Spade(gp, 2, 1),400,50);
            eManager.addEm(new Spade(gp, -2, 1),600,50);
        }
        if (tick == 450){
            eManager.addEm(new Spade(gp, -3, 0),625,150);
            eManager.addEm(new Spade(gp, -2, 0),625,150);
            eManager.addEm(new Spade(gp, -1, 0),625,150);
        }
        if (tick == 500){
            eManager.addEm(new Diamond(gp, 2, 2),350,100);
            eManager.addEm(new Diamond(gp, -2, 2),625,100);
            eManager.addEm(new Diamond(gp, 2, -2),350,400);
            eManager.addEm(new Diamond(gp, -2, -2),625,400);
        }
        if (tick == 680){
            eManager.addEm(new Hearth(gp, 2, 0), 350,200);
            eManager.addEm(new Clover(gp, -3, 0), 625,300);
        }
        if (tick == 760){
            eManager.addEm(new Clover(gp, 3, 0), 350,300);
            eManager.addEm(new Hearth(gp, -2, 0), 625,200);
        }
        if (tick == 900){
            eManager.addEm(new Diamond(gp, 0, 0), 500,250);
            eManager.addEm(new Hearth(gp, -2, 0), 550,250);
            eManager.addEm(new Hearth(gp, 2, 0), 450,250);
        }
        if (tick == 1000){
            eManager.addEm(new Spade(gp, -2, 1), 550,250);
            eManager.addEm(new Spade(gp, 2, 1), 450,250);
            eManager.addEm(new Diamond(gp, 0, 2), 500,250);
            eManager.addEm(new Clover(gp, 0, 2), 500,250);
        }
        if (tick > 1750){
            gp.stage = new Stage06(gp, keyH);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        if (tick >= 1500 && tick < 1750){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g2.drawString("COMPLETADO", (gp.screenWidth/2)-175, gp.screenHeight/2);
        }
    }
}
