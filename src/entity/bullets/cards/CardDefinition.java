package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

public class CardDefinition {
    SpellCard sp;
    GamePanel gp;
    Entity parent;

    public CardDefinition(GamePanel gp, Entity parent){
        this.gp = gp;
        this.parent = parent;

    }
    public SpellCard drawCard(){
        return sp;
    }
}
