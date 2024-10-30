package entity.bullets.cards;

import main.GamePanel;

public class fourShotsDef extends CardDefinition{

    public fourShotsDef(GamePanel gp, int x, int y) {
        super(gp);
        sp = new fourShots(gp, x, y);
    }
}
