package stages;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Stage {
    public GamePanel gp;
    public KeyHandler keyH;

    public Stage(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
    }
    public void update(){
    }
    public void draw(Graphics2D g2){
    }
}
