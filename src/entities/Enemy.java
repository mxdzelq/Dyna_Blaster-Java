package entities;

import DynaBlaster.Handler;
import gfx.Assets;
import tiles.Tile;

import java.awt.*;

/**
 * Klasa przeciwnika
 */

public class Enemy extends Creature {

    /**
     * Zmienne opisujące aktualny kierunek ruchu przeciwnika
     */

    public static final int DIR_UP=1;
    public static final int DIR_DOWN=2;
    public static final int DIR_RIGHT=3;
    public static final int DIR_LEFT=4;
    public static int currentDirection;

    /**
     * Pobranie stanu gracz
     */

    Player player=EntityManager.getPlayer();

    /**
     * Konstruktor przeciwnika
     * @param handler obsługa zdarzeń
     * @param x położenie przeciwnika w płaszczyźnie x
     * @param y położenie przeciwnika w płaszczyźnie y
     */


    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x=4;
        bounds.y=4;
        bounds.width=26;
        bounds.height=24;
        speed=2;

        currentDirection=DIR_DOWN;
    }


    /**
     * Aktualizacja stanu przeciwnika
     */
    @Override
    public void update() {
    move();
    }

    public void die(){}

    /**
     * Narysowanie stanu przeciwnika
     * @param g obiekt graficzny przeciwnika
     */

    @Override
    public void render(Graphics g) {
    g.drawImage(Assets.enemy, (int)x,(int)y,width,height,null);
    //g.setColor(Color.red);
    //g.fillRect((int)(x+bounds.x),(int)(y+bounds.y),bounds.width,bounds.height);
    }

    /**
     * Ruch przeciwnika(jednocześnie sprawdzający czy występuje kolizja z graczem)
     */
    @Override
    public void move(){
       if((!checkCollisionWithPlayer(speed,0f)) && (!checkCollisionWithPlayer(-speed,0f)))
         moveX();
        if((!checkCollisionWithPlayer(0f,speed)) && (!checkCollisionWithPlayer(0f,-speed)))
            moveY();
    }


    /**
     * Ruch w płaszczyźnie x(jeżeli występuje kolizja z jednostką lub blokiem przeciwnik zmienia kierunek)
     */
    @Override
    public void moveX(){
        if(currentDirection==DIR_RIGHT){
            int tx=(int)(x+speed+bounds.x+bounds.width) / Tile.DEFAULT_TILEWIDTH;
            if(collisionWithTile(tx, (int)(y+bounds.y) /Tile.DEFAULT_TILEHEIGHT) &&
                    (collisionWithTile(tx, (int)(y+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT))||
                    (checkEntityCollision(speed,0f))){
                changeDirection();

            }else
                x+=speed;


        }else if(currentDirection==DIR_LEFT){
            int tx=(int)(x-speed+bounds.x) / Tile.DEFAULT_TILEWIDTH;

            if(collisionWithTile(tx, (int)(y+bounds.y) /Tile.DEFAULT_TILEHEIGHT)
                    && (collisionWithTile(tx, (int)(y+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT)) ||
                    (checkEntityCollision(-speed,0f)) ){
                changeDirection();

            }else
                x-=speed;

        }
    }


    /**
     * Ruch w płaszczyźnie y(jeżeli występuje kolizja z jednostką lub blokiem przeciwnik zmienia kierunek)
     */
    public void moveY(){
        if(currentDirection==DIR_UP){
            int ty=(int)(y-speed+bounds.y) / Tile.DEFAULT_TILEHEIGHT;

            if(collisionWithTile((int)(x+bounds.x)/Tile.DEFAULT_TILEWIDTH,ty)&&
                    collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.DEFAULT_TILEWIDTH,ty)||
                    (checkEntityCollision(0f,-speed))){
                changeDirection();

            }else
                y-=speed;

        }else if(currentDirection==DIR_DOWN){

            int ty=(int)(y+speed+bounds.y+bounds.height) /Tile.DEFAULT_TILEHEIGHT;

            if(collisionWithTile((int)(x+bounds.x)/Tile.DEFAULT_TILEWIDTH,ty)&&
                    collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.DEFAULT_TILEWIDTH,ty)||
                    (checkEntityCollision(0f,speed))){
                changeDirection();

            }else
                y+=speed;

        }

    }

    /**
     * Zmiana kierunku ruchu przeciwnika
     */

    private void changeDirection(){
        if(currentDirection==DIR_UP)
            currentDirection=DIR_RIGHT;
        else if(currentDirection==DIR_RIGHT)
            currentDirection=DIR_DOWN;
        else if(currentDirection==DIR_DOWN)
            currentDirection=DIR_LEFT;
        else
            currentDirection=DIR_UP;
    }

    /**
     * Sprawdzenie kolizji z graczem i jednoczesna obsługa stanu gracza, gdy kolizja wystąpi
     * @param xOffset "wyprzedzenie" stanu kolizji z zachowaniem prędkości przeciwnika w płaszczyźnie x
     * @param yOffset "wyprzedzenie" stanu kolizji z zachowaniem prędkości przeciwnika w płaszczyźnie y
     * @return zwrot czy występuje koliizja
     */

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset){
        if(getCollisionBounds(0f,0f).intersects(player.getCollisionBounds(xOffset,yOffset))){
            player.setX(32);
            player.setY(32);
            player.setHealth(player.getHealth()-1);
            return true;
        }return false;

    }

    /**
     * Sprawdzenie kolizji z blokiem
     * @param x położenie bloku w płaszczyźnie x
     * @param y położenie bloku w płaszczyźnie y
     * @return zwrot czy kolizja występuje
     */

    @Override
    protected boolean collisionWithTile(int x,int y){
        return handler.getMap().getTile(x,y).isSolid();
    }


}
