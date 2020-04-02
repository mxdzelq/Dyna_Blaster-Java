package Fire;

import DynaBlaster.Handler;
import config.config;
import entities.Entity;
import entities.StaticEntity;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa ognia skierowanego w prawą stronę
 */

public class FireRight extends StaticEntity {

    /**
     * Animacja ognia
     */


    private Animation fireRight;

    /**
     * Timery czasu życia ognia
     */

    private long timer,lastTime;

    /**
     * Czas życia ognia
     */
    private long timeOfLife=2284;


    private static boolean bombed;


    /**
     * Konstruktor ognia skierowanego w prawo
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireRight(Handler handler, float x, float y) {
        super(handler, x, y, config.fireXwidth, config.fireXheight);

            bounds.x=0;
            bounds.y=10;
            bounds.width=64;
            bounds.height=12;
            fireRight=new Animation(571, Assets.fireRight);
            timer=0;
            lastTime=System.currentTimeMillis();
            timerUpdate();

    }

    @Override
    public void die() {

    }

    /**
     * Aktualizacja timerów
     */

    private void timerUpdate(){
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if(timer>=timeOfLife)
        {
            hurt();
        }
    }


    /**
     * Aktualizacja stanu ognia
     */
    @Override
    public void update() {

            fireRight.update();
            timerUpdate();
            checkFireCollision(0f, 0f);

    }

    /**
     * Sprawdzenie kolizji z jednostkami
     */

    public void checkFireCollision(float xOffset, float yOffset){
        for(Entity e:handler.getMap().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset, yOffset)))
                e.hurt();
        }
    }

    /**
     * Narysowanie stanu ognia
     * @param g obiekt graficzny
     */

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireRight(),(int)(x),(int)(y),width,height,null);
    }

    /**
     * Zwrot aktualnej klatki do animacji
     * @return aktualna klatka
     */

    private BufferedImage getCurrentAnimationFrameOfFireRight(){
        return fireRight.getCurrentFrame();
    }

}
