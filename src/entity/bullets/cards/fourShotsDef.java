package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class fourShotsDef extends CardDefinition{

    public fourShotsDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }
    @Override
    public SpellCard drawCard() {
        return new fourShots(gp, parent);
    }
}
