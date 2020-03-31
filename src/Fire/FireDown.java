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

public class FireDown extends StaticEntity {

    private Animation fireDown;

    private long timer,lastTime;
    private long timeOfLife=2284;


    /**
     * Konstruktor jednostek statycznych
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireDown(Handler handler, float x, float y) {
        super(handler, x, y, 32, 64);

        bounds.x=10;
        bounds.y=0;
        bounds.width=12;
        bounds.height=64;
        fireDown=new Animation(571, Assets.fireDown);
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
        fireDown.update();
        timerUpdate();

    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireDown(),(int)(x),(int)(y),width,height,null);
    }

    private BufferedImage getCurrentAnimationFrameOfFireDown(){
        return fireDown.getCurrentFrame();
    }


}
