package stages;

import entity.enemies.EnemyManager;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;

public class Stage {
    public GamePanel gp;
    public KeyHandler keyH;
    public EnemyManager eManager;
    UserInterface UI;
    Player player;

    public Stage(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
    }
    public void update(){
    }
    public void draw(Graphics2D g2){
    }
}
