package gfx;

import java.awt.image.BufferedImage;

/**
 * Klasa obsługująca arkusz obrazów
 */

public class SpriteSheet {
    /**
     * Zmienna przechowująca arkusz
     */
    private BufferedImage sheet;

    /**
     * Konstruktor obsługi arkusza obrazów
     * @param sheet arkusz obrazów
     */

    public SpriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }

    /**
     * Metoda wycinająca obraz z arkusza
     * @param x położenie początku wycinania w płaszczyźnie x
     * @param y położenie początku wycinania w płaszczyźnie y
     * @param width szerokość wycinka
     * @param height wysokość wycinka
     * @return wycięty obraz
     */

    public BufferedImage crop(int x,int y,int width,int height){
    return sheet.getSubimage(x,y,width,height);
    }
}
