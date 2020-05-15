package SpecialEntities;

import DynaBlaster.Handler;
import entities.EntityManager;
import entities.Player;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;

/**
 * Jednostka zwiększająca zasięg rażenia bomb
 */

public class FireBoost extends SpecialEntity {
    Player player= EntityManager.getPlayer();

    /**
     * Konstruktor boostera zasięgu rażenia
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireBoost(Handler handler, float x, float y) {
        super(handler, x, y, Tile.DEFAULT_TILEWIDTH, Tile.DEFAULT_TILEHEIGHT);
    }

    @Override
    public void update() {
        if(checkCollisionWithPlayer(0f,0f))
            active=false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.fireBoost,(int)(x),(int)(y),width,height,null);
    }

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset){
        if(getCollisionBounds(0f,0f).intersects(player.getCollisionBounds(xOffset,yOffset))){
            player.setFireBoostLevel(player.getFireBoostLevel()+1);
            return true;
        }return false;
    }
}
