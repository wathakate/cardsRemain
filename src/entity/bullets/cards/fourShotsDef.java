package entity.bullets.cards;

import main.GamePanel;

public class fourShotsDef extends cardDefinition{

    public fourShotsDef(GamePanel gp, int x, int y) {
        super(gp);
        sc = new fourShots(gp, x, y);
    }
}
