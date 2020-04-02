package SpecialEntities;

import DynaBlaster.Handler;

import java.awt.*;

/**
 * Klasa jednostek specjalnych(boosterów i przejścia na kolejny poziom)
 */

public abstract class SpecialEntity {

    /**
    Obsługa zdarzeń
     */
    protected Handler handler;

    /**
     * Położenie
     */
    protected float x,y;

    /**
     * Szerokość i wysokość jednostki specjalnej
     */
    protected int width,height;

    /**
     * Prostokąt kolizji jednostki specjalnej
     */
    protected Rectangle bounds;

    /**
     * Sprawdzenie czy jednostka specjalna jest jeszcze dostępna
     */
    protected boolean active=true;

    /**
     * Konstruktor jednostki specjalnej
     * @param handler obsługa zdarzeń
     * @param x położenie w płaszczyźnie x
     * @param y położenie w płaszczyźnie y
     * @param width szerokość jednostki specjalnej
     * @param height wysokość jednostki specjalnej
     */
    public SpecialEntity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;

        bounds=new Rectangle(0,0,width,height);

    }

    /**
     * Aktualizacja stanu jednostki specjalnej
     */
    public abstract void update();

    /**
     * Narysowanie jednostki specjalnej
     * @param g obiekt graficzny
     */
    public abstract void render(Graphics g);

    /**
     * Zwrot prostokąta kolizji
     * @param xOffset 0
     * @param yOffset 0
     * @return prostokąt kolizji
     */
    public Rectangle getCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x+bounds.x+xOffset),(int)(y+bounds.y+yOffset),bounds.width,bounds.height);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
