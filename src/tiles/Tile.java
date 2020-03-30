package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Klasa opisująca bloki, których nie można zniszczyć
 */

public class Tile {
    /**
     * Tablica przechowująca rodzaje bloków
     */

    public static Tile[] tiles=new Tile[10];

    /**
     * Blok trawy zapisany o id 0
     */

    public static Tile grassTile = new GrassTile(0);

    /**
     * Blok ściany zapisany jako id 1
     */

    public static Tile wallTile = new WallTile(1);

    /**
     * Szerokość bloku
     */

    public static final int DEFAULT_TILEWIDTH=32;

    /**
     * Wysokość bloku
     */

    public static final int DEFAULT_TILEHEIGHT=32;

    /**
     * Zmienna opisująca teksturę bloku
     */

    protected BufferedImage texture;

    /**
     * Zmienna opisująca indeks bloku
     */

    protected final int id;

    /**
     * Konstruktor bloku
     * @param texture tekstura bloku
     * @param id indeks bloku
     */

    public Tile(BufferedImage texture,int id){
        this.texture=texture;
        this.id=id;

        tiles[id]=this;
    }

    /**
     * Aktualizacja stanu bloku
     */

    public void update(){

    }

    /**
     * Narysowanie bloku
     * @param g reprezentacja obiektu graficznego
     * @param x położenie bloku w płaszczyźnie x
     * @param y położenie bloku w płaszczyźnie y
     */

    public void render(Graphics g, int x,int y){
g.drawImage(texture,x,y,DEFAULT_TILEWIDTH,DEFAULT_TILEHEIGHT,null);
    }

    /**
     * Metoda opisująca czy z blokiem występują kolizje
     * @return false - domyślnie brak kolizji
     */

    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

}
