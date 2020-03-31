package Fire;

import DynaBlaster.Handler;
import entities.StaticEntity;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa ognia w prawą stronę
 */

public class FireRight extends StaticEntity {

    private Animation fireRight;

    private long timer,lastTime;
    private long timeOfLife=2284;


    private static boolean bombed;


    /**
     * Konstruktor jednostek statycznych
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireRight(Handler handler, float x, float y) {
        super(handler, x, y, 32, 32);

            width=64;
            height=32;
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

    private void timerUpdate(){
        timer+=System.currentTimeMillis()-lastTime;
        lastTime=System.currentTimeMillis();
        if(timer>=timeOfLife)
        {
            hurt();
        }
    }


    @Override
    public void update() {
    fireRight.update();
    timerUpdate();
    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireRight(),(int)(x),(int)(y),width,height,null);
    }

    private BufferedImage getCurrentAnimationFrameOfFireRight(){
        return fireRight.getCurrentFrame();
    }

}
