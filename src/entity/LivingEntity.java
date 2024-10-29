package entity;

import entity.bullets.SpellCard;

public class LivingEntity extends Entity {
    public int lives;
    public int iframes = 0; // Los cuadros en los que la entidad es invulnerable, funciona como timer
    public SpellCard[] sp;

    @Override
    public void update(){
        iframes--;
    }
}
