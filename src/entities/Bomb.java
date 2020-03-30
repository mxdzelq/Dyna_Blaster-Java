package entities;

import DynaBlaster.Handler;
import gfx.Assets;

import java.awt.*;

/**
 * Klasa bomby
 */

public class Bomb extends StaticEntity {

    Player player=EntityManager.getPlayer();

    /**
     * Konstruktor bomby
     * @param handler obsługa zdarzeń
     * @param x położenie bomby w płaszczyźnie x
     * @param y położenie bomby w płaszczyźnie y
     */

    public Bomb(Handler handler, float x, float y) {
        super(handler, x, y, 32, 32);

        bounds.x=0;
        bounds.y=0;
        bounds.width=0;
        bounds.height=0;


    }

    /**
     * Aktualizacja stanu bomby
     */
    @Override
    public void update() {
    }

    /**
     * Narysowanie stanu bomby
     * @param g obiekt graficzny bomby
     */

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bomb,(int)(x),(int)(y),width,height,null);

    }
}
