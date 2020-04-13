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
 * Klasa cegły (bloku niszczalnego) zawierająca przejście na kolejny poziom
 */

public class BrickWithNextLevelDoors extends StaticEntity {

    /**
     * Konstruktor cegły z przejściem na kolejny poziom
     * @param handler obsługa zdarzeń
     * @param x położenie cegły w płaszczyźnie x
     * @param y położenie cegły w płaszczyźnie y
     */

    public BrickWithNextLevelDoors(Handler handler, float x, float y){
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
     * Śmierć cegły i stworzenie obiektu przejścia na kolejny poziom
     */
    public void die(){
        ArrayList<SpecialEntity> specialEntities=SpecialEntityManager.getSpecialEntities();
        NextLevelEntity nextLevelEntity=new NextLevelEntity(handler,x,y);
        specialEntities.add(nextLevelEntity);
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
