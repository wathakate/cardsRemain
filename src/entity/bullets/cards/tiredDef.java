package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class tiredDef extends CardDefinition{
    public tiredDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new tired(gp, parent);
    }
}
