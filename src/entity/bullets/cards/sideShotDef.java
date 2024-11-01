package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class sideShotDef extends CardDefinition{
    public sideShotDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }
    @Override
    public SpellCard drawCard() {
        return new sideShot(gp, parent.x, parent.y + 16, parent);
    }
}
