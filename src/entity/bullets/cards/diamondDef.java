package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class diamondDef extends CardDefinition{
    public diamondDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new diamondPattern(gp, parent.x, parent.y);
    }
}
