package SpecialEntities;

import DynaBlaster.Handler;

import java.awt.*;

/**
 * Jednostka po kolizji z którą gracz przechodzi na kolejny poziom
 */

public class NextLevelEntity extends SpecialEntity {
    /**
     * Konstruktor jednostki specjalnej
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     * @param width   szerokość jednostki specjalnej
     * @param height  wysokość jednostki specjalnej
     */
    public NextLevelEntity(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
