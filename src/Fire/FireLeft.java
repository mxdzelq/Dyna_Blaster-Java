package Fire;

import DynaBlaster.Handler;
import DynaBlaster.config;
import entities.Entity;
import entities.StaticEntity;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa ognia skierowanego w lewo
 */

public class FireLeft extends StaticEntity {

    /**
     * Animacja ognia
     */


    private Animation fireLeft;

    /**
     * Timery czasu życia ognia
     */

    private long timer,lastTime;

    /**
     * Czas życia ognia
     */
    private long timeOfLife=2284;

    /**
     * Prostokąt kolizji rażenia jednostek
     */

    private Rectangle hurtBounds;




    /**
     * Konstruktor ognia skierowanego w lewo
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireLeft(Handler handler, float x, float y) {
        super(handler, x, y, config.fireXwidth, config.fireXheight);

            bounds.x=0;
            bounds.y=0;
            bounds.width=0;
            bounds.height=0;

            hurtBounds=new Rectangle(0,10,64,12);
            hurtBounds.x=0;
            hurtBounds.y=10;
            hurtBounds.width=64;
            hurtBounds.height=12;


            fireLeft=new Animation(571, Assets.fireLeft);
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
        fireLeft.update();
        timerUpdate();
        checkFireCollision(0f,0f);

    }

    /**
     * Sprawdzenie kolizji z jednostkami
     */

    public void checkFireCollision(float xOffset, float yOffset){
        for(Entity e:handler.getMap().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getHurtCollisionBounds(xOffset, yOffset)))
                e.hurt();
        }
    }

    /**
     * Narysowanie stanu ognia
     * @param g obiekt graficzny
     */

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireLeft(),(int)(x),(int)(y),width,height,null);

    }

    /**
     * Zwrot aktualnej klatki do animacji
     * @return aktualna klatka
     */

    private BufferedImage getCurrentAnimationFrameOfFireLeft(){
        return fireLeft.getCurrentFrame();
    }

    /**
     * Pobranie prostokątu kolizji rażenia
     * @param xOffset 0
     * @param yOffset 0
     * @return zwrot prostokąta kolizji
     */

    public Rectangle getHurtCollisionBounds(float xOffset,float yOffset){
        return new Rectangle((int)(x+hurtBounds.x+xOffset),(int)(y+hurtBounds.y+yOffset),hurtBounds.width,hurtBounds.height);
    }



}
