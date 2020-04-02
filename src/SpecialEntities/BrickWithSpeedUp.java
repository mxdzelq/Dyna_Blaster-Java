package SpecialEntities;

import DynaBlaster.Handler;
import entities.Bomb;
import entities.Entity;
import entities.StaticEntity;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa cegły (bloku niszczalnego) zawierająca booster szybkości
 */

public class BrickWithSpeedUp extends StaticEntity {

    /**
     * Konstruktor cegły z boosterem szybkości
     * @param handler obsługa zdarzeń
     * @param x położenie cegły w płaszczyźnie x
     * @param y położenie cegły w płaszczyźnie y
     */

    public BrickWithSpeedUp(Handler handler, float x, float y){
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


    /**
     * Śmierć cegły i stworzenie obiektu boostera szybkości
     */
    public void die(){
       ArrayList<SpecialEntity> specialEntities=SpecialEntityManager.getSpecialEntities();
        SpeedUpBoost speedUpBoost=new SpeedUpBoost(handler,x,y);
       specialEntities.add(speedUpBoost);
    }

    /**
     * Narysowanie stanu cegły
     * @param g obiekt graficzny cegły
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.brick,(int)(x),(int)(y),width,height,null);
    }
}
