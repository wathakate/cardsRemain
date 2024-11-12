package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class cloverDef extends CardDefinition{
    public cloverDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new cloverPattern(gp, parent.x, parent.y);
    }
}
