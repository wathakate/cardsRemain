package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class emLaserDef extends CardDefinition{
    public emLaserDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new emLaser(gp,parent);
    }
}
