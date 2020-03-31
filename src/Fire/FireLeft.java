package Fire;

import DynaBlaster.Handler;
import entities.StaticEntity;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa ognia
 */

public class FireLeft extends StaticEntity {

    private Animation fireLeft;

    private long timer,lastTime;
    private long timeOfLife=2284;


    /**
     * Konstruktor jednostek statycznych
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireLeft(Handler handler, float x, float y) {
        super(handler, x, y, 64, 32);

            bounds.x=0;
            bounds.y=10;
            bounds.width=64;
            bounds.height=12;
            fireLeft=new Animation(571, Assets.fireLeft);
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
        fireLeft.update();
        timerUpdate();

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireLeft(),(int)(x),(int)(y),width,height,null);

    }

    private BufferedImage getCurrentAnimationFrameOfFireLeft(){
        return fireLeft.getCurrentFrame();
    }
}
