package stages;

import entity.Player;
import entity.enemies.EnemyManager;
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
        backDrop = ImageIO.read(getClass().getResourceAsStream("/res/ui/testui.png"));
        name = "1";
        UI = new UserInterface(gp);
        player = new Player(gp,this,keyH);
        eManager = new EnemyManager(gp);

    }
}
