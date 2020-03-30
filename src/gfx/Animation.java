package gfx;

import java.awt.image.BufferedImage;

/**
 * Klasa obsługująca animacje
 */
public class Animation {
    /**
     * Prędkość animacji
     */
    private int speed;

    /**
     * Indeks aktualnej klatki
     */

    private int index;

    /**
     * Zmienne do obsługi czasu wyświetlania klatki
     */

    private long lastTime, timer;

    /**
     * Tablica klatek do wyświetlenia
     */

    private BufferedImage[] frames;

    /**
     * Konstruktor animacji
     * @param speed prędkość zmiany klatki
     * @param frames tablica klatek
     */

    public Animation(int speed, BufferedImage[] frames){
this.speed=speed;
this.frames=frames;
index=0;
timer=0;
lastTime=System.currentTimeMillis();
    }

    /**
     * Aktualizacja stanu animacji
     */

    public void update(){
    timer+=System.currentTimeMillis() - lastTime;
    lastTime=System.currentTimeMillis();

    if(timer>speed){
        index++;
        timer=0;
        if(index>=frames.length)
            index=0;
    }
    }

    /**
     * Pobranie aktualnej klatki
     * @return aktualna klatka
     */

    public BufferedImage getCurrentFrame(){
        return  frames[index];
    }

    /**
     * Pobranie klatki nr 0
     * @return klatka 0
     */

    public BufferedImage getFrame0(){
        return frames[0];
    }
}
