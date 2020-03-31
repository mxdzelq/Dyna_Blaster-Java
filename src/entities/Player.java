package entities;

import DynaBlaster.Handler;
import DynaBlaster.State;
import config.config;
import gfx.Animation;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Klasa gracza
 */

public class Player extends Creature {

    /**
     * Zmienne animacji
     */

    private Animation animDown, animUp, animLeft, animRight;

    protected float xMove,yMove;

    Bomb bomb;

    private boolean canSetBomb=true;



    /**
     * Konstruktor gracz
     * @param handler obsługa zdarzeń
     * @param x położenie gracza w płaszczyźnie x
     * @param y położenie gracza w płaszczyźnie y
     */

    public Player(Handler handler, float x, float y){
        super(handler,x,y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x=8;
        bounds.y=8;
        bounds.width=16;
        bounds.height=20;

        health=3;


        speed= config.defaultPlayerSpeed;
        animDown=new Animation(300,Assets.player_down);
        animUp=new Animation(300,Assets.player_up);
        animLeft=new Animation(300,Assets.player_left);
        animRight=new Animation(300,Assets.player_right);

        xMove=0;
        yMove=0;

        this.bomb=bomb;
    }

    /**
     * Aktualizacja stanu gracza
     */

    @Override
    public void update() {
        animDown.update();
        animRight.update();
        animLeft.update();
        animUp.update();

        checkHealth();
        getInput();
        move();


    }

    /**
     * Ruch gracza
     */

    public void move(){
        if(!checkEntityCollision(xMove,0f))
            moveX();
        /*if(!checkEnemyCollision(xMove,0f)){
                x=0;
        y=0;}*/
        if(!checkEntityCollision(0f,yMove))
            moveY();
    }

    /**
     * Ruch gracza w płaszczyźnie x
     */

    public void moveX(){
        if(xMove>0){//Ruch w prawo

            int tx=(int)(x+xMove+bounds.x+bounds.width) / Tile.DEFAULT_TILEWIDTH;
            if(!collisionWithTile(tx, (int)(y+bounds.y) /Tile.DEFAULT_TILEHEIGHT) && (!collisionWithTile(tx, (int)(y+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT))){
                x+=xMove;
            }
        }else if(xMove<0){//ruch w lewo
            int tx=(int)(x+xMove+bounds.x) / Tile.DEFAULT_TILEWIDTH;
            if(!collisionWithTile(tx, (int)(y+bounds.y) /Tile.DEFAULT_TILEHEIGHT) && (!collisionWithTile(tx, (int)(y+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT))){
                x+=xMove;
            }
        }

    }

    /**
     * Ruch gracza w płaszczyźnie y
     */

    public void moveY(){
        if(yMove<0){//Ruch w górę
            int ty=(int)(y+yMove+bounds.y) /Tile.DEFAULT_TILEHEIGHT;

            if(!collisionWithTile((int)(x+bounds.x)/Tile.DEFAULT_TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.DEFAULT_TILEWIDTH,ty)){
                y+=yMove;
            }
        }else if(yMove>0){//Ruch w dół
            int ty=(int)(y+yMove+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT;

            if(!collisionWithTile((int)(x+bounds.x)/Tile.DEFAULT_TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.DEFAULT_TILEWIDTH,ty)){
                y+=yMove;
            }
        }
    }

    /**
     * Sprawdzenie, czy gracz posiada jeszcze życia
     */

    public void checkHealth(){
        if(this.health==0)
               State.setState(handler.getGame().menuState);
    }

    /**
     * Postawienie bomby
     * @param x miejsce postawienia bomby w płaszczyźnie x (położenie gracza)
     * @param y miejsce postawienia bomby w płaszczyźnie y (położenie gracza)
     */

    public void setBomb(float x, float y){
        ArrayList<Entity> entities=handler.getMap().getEntityManager().getEntities();
        Bomb bomb=new Bomb(handler,x,y);
        entities.add(bomb);

    }


    /**
     * Obsługa klawiszy
     */

    private void getInput(){
        xMove=0;
        yMove=0;

        if(handler.getKeyManager().up)
            yMove=-speed;
        if(handler.getKeyManager().down)
            yMove=speed;
        if(handler.getKeyManager().left)
            xMove=-speed;
        if(handler.getKeyManager().right)
            xMove=speed;
        if(handler.getKeyManager().bombPlace){
            if(canSetBomb) {
                setBomb(x, y);
                if(bomb.isBombed())
                canSetBomb=true;
                else
                    canSetBomb=false;
            }
        }

    }

    /**
     * Narysowanie stanu gracza
     * @param g Obiekt graficzny gracza
     */
    @Override
    public void render(Graphics g) {
    g.drawImage(getCurrentAnimationFrame(),(int)x,(int)y,width,height,null);

    }

    public void die(){}

    /**
     * Obsługa animacji ruchu
     * @return zwraca aktualną klatkę animacji
     */

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove<0){
            return animLeft.getCurrentFrame();
        }else if(xMove>0){
            return animRight.getCurrentFrame();
        }else if(yMove<0){
            return animUp.getCurrentFrame();
        }else if(yMove>0){
            return animDown.getCurrentFrame();
        }else{
            return animDown.getFrame0();
        }
    }

    public void setCanSetBomb(boolean canSetBomb) {
        this.canSetBomb = canSetBomb;
    }
}
