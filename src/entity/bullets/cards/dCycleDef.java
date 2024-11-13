package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class dCycleDef extends CardDefinition{
    public dCycleDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new doubleCycle(gp, parent);
    }
}
