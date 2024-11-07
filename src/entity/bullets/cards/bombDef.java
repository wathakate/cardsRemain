package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class bombDef extends CardDefinition {

    public bombDef(GamePanel gp, Entity parent) {
        super(gp, parent);
        try {
            card = ImageIO.read(getClass().getResourceAsStream("/res/cardArt/bomb.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public SpellCard drawCard() {
        return new bomb(gp, parent.x, parent.y);
    }
}
