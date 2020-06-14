package Fire;

import DynaBlaster.Handler;
import DynaBlaster.config;
import entities.Entity;
import entities.EntityManager;
import entities.StaticEntity;
import gfx.Animation;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa ognia skierowanego w górę
 */

public class FireUp extends StaticEntity {

    /**
     * Animacja ognia
     */


    private Animation fireUp;

    /**
     * Timery czasu życia ognia
     */

    private long timer,lastTime;

    /**
     * Czas życia ognia
     */
    private long timeOfLife=config.fireTimeOfLife;

    /**
     * Prostokąt kolizji rażenia jednostek
     */

    private Rectangle hurtBounds;


    /**
     * Konstruktor ognia skierowanego w górę
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public FireUp(Handler handler, float x, float y) {
        super(handler, x, y, config.fireYwidth, config.fireYheight+ EntityManager.getPlayer().getFireBoostLevel()*config.fireBoostValue);

        bounds.x=0;
        bounds.y=0;
        bounds.width=0;
        bounds.height=0;


        hurtBounds=new Rectangle(10,0,12,64+EntityManager.getPlayer().getFireBoostLevel()*config.fireBoostValue);
        hurtBounds.x=10;
        hurtBounds.y=0;
        hurtBounds.width=12;
        hurtBounds.height=64+EntityManager.getPlayer().getFireBoostLevel()*config.fireBoostValue;

        fireUp=new Animation(357, Assets.fireUp);
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
        //System.out.println(timer);
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
        fireUp.update();
        timerUpdate();
        checkTileCollision();
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
     * Obsługa kolizji ze ścianą
     */

    private void checkTileCollision(){
        for(int i=0;i<height;i++) {
            int ty = (int) (y+i) / Tile.DEFAULT_TILEHEIGHT;
            if (collisionWithTile((int) (x+8) / Tile.DEFAULT_TILEWIDTH,ty) || (collisionWithTile((int) (x+ 22) / Tile.DEFAULT_TILEWIDTH,ty))) {
                y=y+i;
                height = height-i;
                hurtBounds.y=hurtBounds.y+i;
                hurtBounds.height=hurtBounds.height-i;

            }
        }
    }

    /**
     * Narysowanie stanu ognia
     * @param g obiekt graficzny
     */

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrameOfFireUp(),(int)(x),(int)(y),width,height,null);

    }

    /**
     * Zwrot aktualnej klatki do animacji
     * @return aktualna klatka
     */

    private BufferedImage getCurrentAnimationFrameOfFireUp(){
        return fireUp.getCurrentFrame();
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

    /**
     * Zwrot czy wystąpiła kolizja ze ścianą
     * @param x położenie ognia w płaszczyźnie x
     * @param y położenie ognia w płaszczyźnie y
     * @return czy kolizja występuje
     */

    protected boolean collisionWithTile(int x,int y){
        return handler.getMap().getTile(x,y).isSolid();
    }
}
