package entity;

import main.GamePanel;

public class Enemy extends Entity{
    int hp;
    GamePanel gp;
    String sprite;
    
    public Enemy(GamePanel gp){
        this.gp = gp;
        setImage("/res/enemy/testEm.png");
    }
    
}
