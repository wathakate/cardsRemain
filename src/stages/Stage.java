package stages;

import entity.enemies.EnemyManager;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;
import userInterface.UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Stage {
    public GamePanel gp;
    public KeyHandler keyH;
    public EnemyManager eManager;
    public String name;
    public Color backColor;
    public BufferedImage backDrop;
    public int tick = 0;
    UserInterface UI;
    Player player;

    public Stage(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
    }
    public void update(){
        tick++;
    }
    public void draw(Graphics2D g2){
    }
}
