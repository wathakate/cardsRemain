package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class bombDef extends CardDefinition {

    public bombDef(GamePanel gp, Entity parent) {
        super(gp, parent);
    }
    @Override
    public SpellCard drawCard() {
        return new bomb(gp, parent.x, parent.y);
    }
}
