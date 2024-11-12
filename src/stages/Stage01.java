package stages;

import entity.Player;
import entity.enemies.EnemyManager;
import entity.enemies.Spade;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Stage01 extends Stage{
    public Stage01(GamePanel gp, KeyHandler keyH) throws IOException {
        super(gp, keyH);
        backColor = Color.LIGHT_GRAY;
        name = "1";
        UI = new UserInterface(gp);
        UI.setUiImage("/res/ui/stage01.png");
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
        if (tick == 200){
            eManager.addEm(new Spade(gp, 2, 3),400,50);
            eManager.addEm(new Spade(gp, -2, 3),600,50);
        }
        if (tick == 220){
            eManager.addEm(new Spade(gp, 0, 2),gp.screenWidth/2,50);
        }
        if (tick == 300){
            eManager.addEm(new Spade(gp, 2, 3),400,50);
            eManager.addEm(new Spade(gp, -2, 3),600,50);
            eManager.addEm(new Spade(gp, 2, 0),350,200);
            eManager.addEm(new Spade(gp, -2, 0),625,200);
        }
        if (tick == 360){
            eManager.addEm(new Spade(gp, 2, 3),400,50);
            eManager.addEm(new Spade(gp, -2, 3),600,50);
        }
        if (tick == 380){
            eManager.addEm(new Spade(gp, 2, 1),400,50);
            eManager.addEm(new Spade(gp, -2, 1),600,50);
        }
        if (tick == 420){ // nice
            eManager.addEm(new Spade(gp, 1, 3),400,50);
            eManager.addEm(new Spade(gp, -1, 3),600,50);
        }
        if (tick == 500){
            eManager.addEm(new Spade(gp, 2, 1),400,200);
            eManager.addEm(new Spade(gp, -2, 1),600,200);
            eManager.addEm(new Spade(gp, 2, -1),350,400);
            eManager.addEm(new Spade(gp, -2, -1),625,400);
        }
        if (tick == 550){
            eManager.addEm(new Spade(gp, 1, 0),350,100);
            eManager.addEm(new Spade(gp, -1, 0),625,100);
            eManager.addEm(new Spade(gp, 2, 0),350,300);
            eManager.addEm(new Spade(gp, -2, 0),625,300);
        }
        if (tick == 640){
            eManager.addEm(new Spade(gp, 2, 2),400,200);
            eManager.addEm(new Spade(gp, -2, 2),600,200);
            eManager.addEm(new Spade(gp, 2, -2),350,400);
            eManager.addEm(new Spade(gp, -2, -2),625,400);
        }
        if (tick == 660){
            eManager.addEm(new Spade(gp, 2, 0),350,100);
            eManager.addEm(new Spade(gp, -2, 0),625,100);
            eManager.addEm(new Spade(gp, 1, 0),350,300);
            eManager.addEm(new Spade(gp, -1, 0),625,300);
        }
        if (tick == 1250){
            gp.stage = new Stage02(gp, keyH);
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
