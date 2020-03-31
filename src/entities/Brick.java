package entities;

import DynaBlaster.Handler;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;

/**
 * Klasa cegły (bloku niszczalnego)
 */

public class Brick extends StaticEntity {

    /**
     * Konstruktor cegły
     * @param handler obsługa zdarzeń
     * @param x położenie cegły w płaszczyźnie x
     * @param y położenie cegły w płaszczyźnie y
     */

    public Brick(Handler handler, float x, float y){
        super(handler, x, y, Tile.DEFAULT_TILEWIDTH, Tile.DEFAULT_TILEHEIGHT);

        bounds.x=1;
        bounds.y=1;
        bounds.width=31;
        bounds.height=31;
    }

    /**
     * Aktualizacja stanu cegły
     */
    @Override
    public void update() {

    }

    public void die(){}

    /**
     * Narysowanie stanu cegły
     * @param g obiekt graficzny cegły
     */
    @Override
    public void render(Graphics g) {
    g.drawImage(Assets.brick,(int)(x),(int)(y),width,height,null);
        //g.setColor(Color.red);
        //g.fillRect((int)(x+bounds.x),(int)(y+bounds.y),bounds.width,bounds.height);
    }
}
