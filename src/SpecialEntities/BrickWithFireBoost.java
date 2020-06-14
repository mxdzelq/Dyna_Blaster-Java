package SpecialEntities;
import DynaBlaster.Handler;
import entities.StaticEntity;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa cegły z boosterem ognia
 */

public class BrickWithFireBoost extends StaticEntity {


    /**
     * Konstruktor jednostek statycznych
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public BrickWithFireBoost(Handler handler, float x, float y) {
        super(handler, x, y, Tile.DEFAULT_TILEWIDTH, Tile.DEFAULT_TILEHEIGHT);
        bounds.x=1;
        bounds.y=1;
        bounds.width=31;
        bounds.height=31;
    }

    @Override
    public void die() {
        ArrayList<SpecialEntity> specialEntities=SpecialEntityManager.getSpecialEntities();
        FireBoost fireBoost=new FireBoost(handler,x,y);
        specialEntities.add(fireBoost);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.brick,(int)(x),(int)(y),width,height,null);
    }
}
