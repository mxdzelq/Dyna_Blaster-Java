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
 * Klasa ognia skierowanego w dół
 */

public class FireDown extends StaticEntity {

    /**
     * Animacja ognia
     */

    private Animation fireDown;

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
     * Konstruktor ognia skierowanego w dół
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireDown(Handler handler, float x, float y) {
        super(handler, x, y, config.fireYwidth, config.fireYheight);

        bounds.x=0;
        bounds.y=0;
        bounds.width=0;
        bounds.height=0;


        hurtBounds=new Rectangle(10,0,12,64);
        hurtBounds.x=10;
        hurtBounds.y=0;
        hurtBounds.width=12;
        hurtBounds.height=64;

        fireDown=new Animation(571, Assets.fireDown);
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
        System.out.println(timer);
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
        fireDown.update();
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
        g.drawImage(getCurrentAnimationFrameOfFireDown(),(int)(x),(int)(y),width,height,null);
    }

    /**
     * Zwrot aktualnej klatki do animacji
     * @return aktualna klatka
     */

    private BufferedImage getCurrentAnimationFrameOfFireDown(){
        return fireDown.getCurrentFrame();
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
