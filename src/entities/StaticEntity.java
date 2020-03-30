package entities;

import DynaBlaster.Handler;

/**
 * Jednostki statyczne(które nie mogą się ruszać np. bloki cegły lub bomby)
 */

public abstract class StaticEntity extends Entity {

    /**
     * Konstruktor jednostek statycznych
     * @param handler obsługa zdarzeń
     * @param x położenie w płaszczyźnie x
     * @param y położenie w płaszczyźnie y
     * @param width szerokość
     * @param height wysokość
     */

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }
}
