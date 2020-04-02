package entities;

import DynaBlaster.Handler;
import Fire.*;
import config.config;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Klasa bomby
 */

public class Bomb extends StaticEntity{

    /**
     * Timery bomby
     */

    private long timer,lastTime;

    /**
     * Czas życia bomby
     */
    private long timeToBoom= config.timeToBoom;

    /**
     * Sprawdzenie czy bomba wybuchła
     */
    private static boolean bombed;

    /**
     * Sprawdzenie czy bomba stworzyła ogień
     */

    private static boolean fireRightPlaced,fireLeftPlaced,fireUpPlaced,fireDownPlaced;


    /**
     * Animacja wybuchu
     */
    private Animation boom;

    /**
     * Konstruktor bomby
     * @param handler obsługa zdarzeń
     * @param x położenie bomby w płaszczyźnie x
     * @param y położenie bomby w płaszczyźnie y
     */

    public Bomb(Handler handler, float x, float y) {
        super(handler, x, y, 32, 32);

        bounds.x=0;
        bounds.y=0;
        bounds.width=0;
        bounds.height=0;

        fireRightPlaced=false;
        fireLeftPlaced=false;
        fireUpPlaced=false;
        fireDownPlaced=false;


        this.bombed=false;

        boom=new Animation(572,Assets.bomb_boom);

        timer=0;
        lastTime=System.currentTimeMillis();


    }

    /**
     * Aktualizacja stanu bomby
     */
    @Override
    public void update() {

        boom.update();
        timerUpdate();

    }

    public void die(){}



    /**
     * Narysowanie stanu bomby
     * @param g obiekt graficzny bomby
     */

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(),(int)(x),(int)(y),width,height,null);

    }

    private BufferedImage getCurrentAnimationFrame(){
        return boom.getCurrentFrame();
    }


    /**
     * Akrualizacja timerów i obsługa wybuchu
     */
    public void timerUpdate(){
            timer += System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            if (timer >= timeToBoom) {
                hurt();
                EntityManager.getPlayer().setCanSetBomb(true);
            }
            if (timer >= 1716 && fireRightPlaced == false) {
                ArrayList<Entity> entities = handler.getMap().getEntityManager().getEntities();
                FireRight fireRight = new FireRight(handler, x + 32, y + 0);
                entities.add(fireRight);
                fireRightPlaced = true;
            }
            if (timer >= 1716 && fireLeftPlaced == false) {
                ArrayList<Entity> entities = handler.getMap().getEntityManager().getEntities();
                FireLeft fireLeft = new FireLeft(handler, x - 64, y + 0);
                entities.add(fireLeft);
                fireLeftPlaced = true;
            }
            if (timer >= 1716 && fireUpPlaced == false) {
                ArrayList<Entity> entities = handler.getMap().getEntityManager().getEntities();
                FireUp fireUp = new FireUp(handler, x, y - 64);
                entities.add(fireUp);
                fireUpPlaced = true;
            }
            if (timer >= 1716 && fireDownPlaced == false) {
                ArrayList<Entity> entities = handler.getMap().getEntityManager().getEntities();
                FireDown fireDown = new FireDown(handler, x, y + 32);
                entities.add(fireDown);
                fireDownPlaced = true;
            }

    }




    public void setBombed(boolean bombed) {
        this.bombed = bombed;
    }

    public static boolean isBombed() {
        return bombed;
    }

    public long getTimer() {
        return timer;
    }
}
