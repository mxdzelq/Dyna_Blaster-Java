package SpecialEntities;

import DynaBlaster.Handler;

import java.awt.*;

/**
 * Jednostka zwiększająca zasięg rażenia bomb
 */

public class FireBoost extends SpecialEntity {
    /**
     * Konstruktor boostera zasięgu rażenia
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     * @param width   szerokość jednostki specjalnej
     * @param height  wysokość jednostki specjalnej
     */
    public FireBoost(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
