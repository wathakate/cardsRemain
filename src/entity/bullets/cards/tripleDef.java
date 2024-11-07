package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class tripleDef extends CardDefinition{
    public tripleDef(GamePanel gp, Entity parent) {
        super(gp, parent);
        try {
            card = ImageIO.read(getClass().getResourceAsStream("/res/cardArt/triple.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SpellCard drawCard() {
        return new tripleShot(gp, parent);
    }
}
