package stages;

import entity.Player;
import entity.enemies.*;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class Stage04 extends Stage{
    public Stage04(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.DARK_GRAY;
        name = "4";
        UI = new UserInterface(gp);
        UI.setUiImage("/res/ui/stage04.png");
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
            eManager.addEm(new Clover(gp, 0, 0), gp.screenWidth/2,200);
        }
        if (tick == 220){
            eManager.addEm(new Clover(gp, 2, 3),400,50);
            eManager.addEm(new Clover(gp, -2, 3),600,50);
            eManager.addEm(new Clover(gp, 2, 0),350,200);
            eManager.addEm(new Clover(gp, -2, 0),625,200);
        }
        if (tick == 330){
            eManager.addEm(new Clover(gp, 2, 2),350,100);
            eManager.addEm(new Clover(gp, -2, 2),625,100);
            eManager.addEm(new Clover(gp, 2, -2),350,400);
            eManager.addEm(new Clover(gp, -2, -2),625,400);
        }
        if (tick == 460){
            eManager.addEm(new Clover(gp, 2, 0),350,284);
            eManager.addEm(new Clover(gp, -2, 0),625,284);
            eManager.addEm(new Clover(gp, 0, 3),496,50);
            eManager.addEm(new Clover(gp, 0, -3),496,475);
        }
        if (tick == 600){
            eManager.addEm(new Clover(gp, 2, 3),496,284);
            eManager.addEm(new Clover(gp, -2, 3),496,284);
            eManager.addEm(new Clover(gp, 2, -3),496,284);
            eManager.addEm(new Clover(gp, -2, -3),496,284);
        }
        if (tick == 800){
            eManager.addEm(new Clover(gp, 2, 3),350,284);
            eManager.addEm(new Clover(gp, -2, 3),625,284);
            eManager.addEm(new Clover(gp, 2, -3),350,284);
            eManager.addEm(new Clover(gp, -2, -3),625,284);
        }
        if (tick == 900){
            eManager.addEm(new Clover(gp, 2, 0), 350,200);
            eManager.addEm(new Clover(gp, -3, 0), 625,300);
        }
        if (tick == 950){
            eManager.addEm(new Clover(gp, 3, 0), 350,300);
            eManager.addEm(new Clover(gp, -2, 0), 625,200);
        }
        if (tick == 1100){ // por alguna razon no hace nada??????
            eManager.addEm(new Clover(gp, 0, 0), 500,250);
            eManager.addEm(new Clover(gp, -2, 0), 550,250);
            eManager.addEm(new Clover(gp, 2, 0), 450,250);
            eManager.addEm(new Clover(gp, -2, 1), 550,250);
            eManager.addEm(new Clover(gp, 2, 1), 450,250);
            eManager.addEm(new Clover(gp, 0, 2), 500,250);
            eManager.addEm(new Clover(gp, 0, 2), 500,250);
            eManager.addEm(new Clover(gp, 0, -2), 500,250);
            eManager.addEm(new Clover(gp, 0, -2), 500,250);
        }
        if (tick >= 2000){
            gp.stage = new Stage05(gp, keyH);
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
