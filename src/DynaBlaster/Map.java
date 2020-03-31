package DynaBlaster;

import config.config;
import entities.*;
import tiles.Tile;

import java.awt.*;

/**
 * Klasa poziomu
 */

public class Map {

    /**
     * Obsługa zdarzeń
     */

    private Handler handler;

    /**
     * Szerokość i wysokość poziomu
     */

    private int width,height;

    /**
     * Miejsce pojawienia się gracza w płaszczyźnie x
     */

    private int spawnX = config.playerSpawnX;

    /**
     * Miejsce pojawienia się gracza w płaszczyźnie y
     */

    private int spawnY = config.playerSpawnY;

    /**
     * Tablica bloków
     */
    private int[][] tiles;

    /**
     * Zarządzanie jednostkami
     */

    private EntityManager entityManager;

    /**
     * Konstruktor poziomu
     * @param handler obsługa zdarzeń
     */

    public Map(Handler handler){
    this.handler=handler;
    entityManager=new EntityManager(handler, new Player(handler,32,32));
    //entityManager.addEntity(new Bomb(handler,300,300));
    //entityManager.addEntity(new Enemy(handler,200,200));
    //entityManager.addEntity(new Fire(handler,200,200,3));

    loadMap();
    loadEntities();

    entityManager.getPlayer().setX(spawnX);
    entityManager.getPlayer().setY(spawnY);

    }

    /**
     * Aktualizacja stanu poziomu
     */

    public void update(){
entityManager.update();
    }

    /**
     * Narysowanie stanu poziomu
     * @param g obiekt graficzny
     */

    public void render(Graphics g){
for(int y=0;y<height;y++){
    for(int x=0;x<width;x++){
            getTile(x, y).render(g, x * Tile.DEFAULT_TILEWIDTH, y * Tile.DEFAULT_TILEHEIGHT);
    }
}
entityManager.render(g);
    }

    /**
     * Pobranie bloku
     * @param x położenie bloku w płaszczyźnie x
     * @param y położenie bloku w płaszczyźnie y
     * @return
     */

    public Tile getTile(int x,int y){
        if(x<0 || y<0 || x>=width || y>=height)
            return Tile.grassTile;

        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null)
            return Tile.grassTile;
        return t;
    }

    /**
     * Załadowanie bloków na mapę
     */

    private void loadMap(){
        String level=config.level1;
        String[] tokens=level.split("\\s+");
width=config.levelWidth;
height=config.levelHeight;
spawnX=config.playerSpawnX;
spawnY=config.playerSpawnY;


tiles=new int[width][height];
for(int y=0;y<height;y++){
    for(int x=0;x<width;x++){
        tiles[x][y]=Integer.parseInt(tokens[x+y*width]);
    }
}
    }

    /**
     * Załadowanie jednostek na mapę
     */

    private void loadEntities(){
        int x=0;
        int y=0;
        int w=0;
        int h=0;

       //entityManager=new EntityManager(handler, new Player(handler,32,32));


        String level=config.level1;

        for (int i=0; i<level.length(); i++) {
            char item = level.charAt(i);

            switch(item){
                case '\n':
                    y+=32;
                    if(0<x){
                        w=x;
                    }
                    x=0;
                    break;

                case ' ':
                    x+=32;
                    break;

                case '2':
                    entityManager.addEntity(new Brick(handler, x,y));
                    x+=32;
                    break;

                case '3':
                    entityManager.addEntity(new Enemy(handler,x,y));
                    x+=32;
                    break;

            }
            h=y;
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
