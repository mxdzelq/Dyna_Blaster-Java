package tiles;

import gfx.Assets;

import java.awt.image.BufferedImage;

/**
 * Klasa opisująca blok ściany
 */

public class WallTile extends Tile {
    public WallTile(int id) {
        super(Assets.wall,id);
    }

    /**
     * Metoda opisująca czy występują kolizje z blokiem
     * @return true - z blokiem występują kolizje
     */

    public boolean isSolid(){
        return true;
    }
}
