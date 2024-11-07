package entity.bullets.cards;

import entity.Entity;
import entity.bullets.SpellCard;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class laserDef extends CardDefinition{
    public laserDef(GamePanel gp, Entity parent) {
        super(gp, parent);
        try {
            card = ImageIO.read(getClass().getResourceAsStream("/res/cardArt/laser.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SpellCard drawCard() {
        return new laser(gp, parent.x, parent.y);
    }
}
