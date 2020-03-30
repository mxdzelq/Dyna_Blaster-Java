package entities;

import DynaBlaster.Handler;
import tiles.Tile;

/**
 * Klasa jednostek, które się poruszają(gracza i przeciwnika)
 */

public abstract class Creature extends Entity{

    /**
     * Zmienne statyczne
     */

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=32;
    public static final int DEFAULT_CREATURE_HEIGHT=32;

    /**
     * Życie jednostki
     */

    protected int health;

    /**
     * Prędkość jednostki
     */

    protected float speed;

    /**
     * Konstruktor kreatury
     * @param handler obsługa zdarzeń
     * @param x położenie w płaszczyźnie x
     * @param y położenie w płaszczyźnie y
     * @param width szerokość jednostki
     * @param height wysokość jednostki
     */


    public Creature(Handler handler,float x, float y, int width, int height) {
        super(handler,x, y,width,height);
        health=DEFAULT_HEALTH;
        speed=DEFAULT_SPEED;

    }

    /**
     * Ruch jednostki
     */

    public void move(){
    }

    /**
     * Ruch jednostki w płaszczyźnie x
     */

    public void moveX(){
    }

    /**
     * Ruch jednostki w płaszczyźnie y
     */

    public void moveY(){
    }

    /**
     * Sprawdzenie czy występuje kolizja z blokiem niezniczalnym
     * @param x położenie bloku w płaszczyźnie x
     * @param y położenie bloku w płaszczyźnie y
     * @return sprawdzenie czy z blokiem występują kolizje
     */

    protected boolean collisionWithTile(int x,int y){
        return handler.getMap().getTile(x,y).isSolid();
    }



    //GETTERS AND SETTERS
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }


}
