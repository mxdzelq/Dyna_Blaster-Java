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

public class FireUp extends StaticEntity {

    private Animation fireUp;

    private long timer,lastTime;
    private long timeOfLife=2284;


    /**
     * Konstruktor jednostek statycznych
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireUp(Handler handler, float x, float y) {
        super(handler, x, y, 32, 64);

        bounds.x=10;
        bounds.y=0;
        bounds.width=12;
        bounds.height=64;
        fireUp=new Animation(571, Assets.fireUp);
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
        System.out.println(timer);
        if(timer>=timeOfLife)
        {
            hurt();
        }
    }


    @Override
    public void update() {
        fireUp.update();
        timerUpdate();

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireUp(),(int)(x),(int)(y),width,height,null);
    }

    private BufferedImage getCurrentAnimationFrameOfFireUp(){
        return fireUp.getCurrentFrame();
    }


}
