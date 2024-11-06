package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class tripleDef extends CardDefinition{
    public tripleDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new tripleShot(gp, parent);
    }
}
