package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class sideShotDef extends CardDefinition{
    public sideShotDef(GamePanel gp, Entity parent) {
        super(gp, parent);
        try {
            card = ImageIO.read(getClass().getResourceAsStream("/res/cardArt/sideShot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public SpellCard drawCard() {
        return new sideShot(gp, parent.x, parent.y + 16, parent);
    }
}
