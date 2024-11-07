package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CardDefinition {
    SpellCard sp;
    GamePanel gp;
    Entity parent;
    BufferedImage card;

    public CardDefinition(GamePanel gp, Entity parent) {
        this.gp = gp;
        this.parent = parent;
    }
    public SpellCard drawCard(){
        return sp;
    }

    public BufferedImage getCard() {
        return card;
    }
}
