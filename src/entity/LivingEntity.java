package entity;

import entity.bullets.SpellCard;
import entity.bullets.cards.cardDefinition;

import java.awt.*;
import java.util.ArrayList;

public class LivingEntity extends Entity {
    public int lives;
    public int iframes = 0; // Los cuadros en los que la entidad es invulnerable, funciona como timer
    public cardDefinition[] sp;
    public ArrayList<SpellCard> drawnCards = new ArrayList<>();

    @Override
    public void update(){
        iframes--;
        for (int i = 0; i < drawnCards.size(); i++) {
            drawnCards.get(i).update();
       }
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (int i = 0; i < drawnCards.size(); i++) {
            drawnCards.get(i).draw(g);
        }
    }
}
