package SpecialEntities;

import DynaBlaster.Handler;
import entities.EntityManager;
import entities.Player;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;

/**
 * Jednostka zwiększająca prędkość gracza
 */
public class SpeedUpBoost extends SpecialEntity {

    /**
     * Pobranie obiektu gracza
     */
    Player player=EntityManager.getPlayer();

    /**
     * Konstruktor boostera prędkości
     * @param handler obsługa zdarzeń
     * @param x położenie w płaszczyźnie x
     * @param y położenie w płaszczyźnie y
     */
    public SpeedUpBoost(Handler handler, float x, float y) {
        super(handler, x, y, Tile.DEFAULT_TILEWIDTH, Tile.DEFAULT_TILEHEIGHT);
    }

    @Override
    public void update() {
        if(checkCollisionWithPlayer(0f,0f))
            active=false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.speedUp,(int)(x),(int)(y),width,height,null);
    }

    /**
     * Sprawdzenie kolizji z graczem i zwiększenie jego prędkości
     * @param xOffset 0
     * @param yOffset 0
     * @return zwrot czy kolizja występuje
     */

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset){
        if(getCollisionBounds(0f,0f).intersects(player.getCollisionBounds(xOffset,yOffset))){
            player.setSpeed(player.getSpeed()+1);
            return true;
        }return false;
    }
}
