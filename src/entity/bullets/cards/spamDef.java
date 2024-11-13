package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class spamDef extends CardDefinition{
    public spamDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }

    @Override
    public SpellCard drawCard() {
        return new spam(gp, parent);
    }
}
