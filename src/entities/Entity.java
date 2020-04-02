package entities;

import DynaBlaster.Handler;

import java.awt.*;

/**
 * Klasa jednostki
 */

public abstract class Entity {

    /**
     * Obsługa zdarzeń
     */

    protected Handler handler;

    /**
     * Położenie jednostki
     */

    protected float x,y;

    /**
     * Szerokość i wysokość jednostki
     */

    protected int width,height;

    /**
     * Prostokąt opisujący granice kolizji jednostki
     */

    protected Rectangle bounds;

    /**
     * Życie jednostki
     */

    protected int health;

    public static final int DEFAULT_HEALTH = 1;

    protected boolean active=true;

    /**
     * Konstruktor jednostki
     * @param handler obsługa zdarzeń
     * @param x położenie w płaszczyźnie x
     * @param y położenie w płaszczyźnie y
     * @param width szerokość jednostki
     * @param height wysokość jednostki
     */

    public Entity(Handler handler,float x, float y, int width,int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        health=DEFAULT_HEALTH;

        bounds=new Rectangle(0,0,width,height);
    }

    public abstract void die();

    /**
     * Otrzymanie obrażeń przez jednostkę z obsługą zniszczenia jednostki
     */

    public void hurt(){
        health-=1;
        if(health<=0){
            active=false;
            die();
        }
    }

    /**
     * Sprawdzenie kolizji między jednostkami
     * @param xOffset wyprzedzenie ruchu jednostki w płaszczyźnie x(sprawdzenie kolizji przed wykonaniem ruchu)
     * @param yOffset wyprzedzenie ruchu jednostki w płaszczyźnie y(sprawdzenie kolizji przed wykonaniem ruchu)
     * @return zwrot czy kolizja występuje
     */

    public boolean checkEntityCollision(float xOffset, float yOffset){
        for(Entity e:handler.getMap().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                return true;
        }
        return false;
    }

    /**
     * Zwrot granic kolizji jednostki
     * @param xOffset wyprzedzenie ruchu jednostki w płaszczyźnie x(sprawdzenie kolizji przed wykonaniem ruchu)
     * @param yOffset wyprzedzenie ruchu jednostki w płaszczyźnie y(sprawdzenie kolizji przed wykonaniem ruchu)
     * @return
     */

    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
