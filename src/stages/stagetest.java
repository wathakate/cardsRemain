package stages;

import entity.bullets.cards.fourShots;
import entity.enemies.*;
import entity.Player;
import entity.bullets.BulletGenerator;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class stagetest extends Stage{
    public stagetest(GamePanel gp, KeyHandler keyH) throws IOException {
        super(gp, keyH);
        backColor = Color.CYAN;
        backDrop = ImageIO.read(getClass().getResourceAsStream("/res/ui/testui.png"));
        name = "0";
        UI = new UserInterface(gp);
        player = new Player(gp,this,keyH);
        eManager = new EnemyManager(gp);
    }
    @Override
    public void update(){
        super.update();
        if (tick == 1){
            eManager.addEm(new Clover(gp, 0, 0), 500, 200);
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
