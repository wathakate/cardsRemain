package stages;

import entity.Player;
import main.GamePanel;
import userInterface.UserInterface;

import java.awt.*;

public class Stage {
    GamePanel gp;
    Player player;
    UserInterface UI;

    public Stage(GamePanel gp){
        this.gp = gp;
        player = new Player(gp, gp.keyH);
        UI = new UserInterface(gp);
    }
    public void update(){
    }
    public void draw(Graphics2D g2){
    }
}
