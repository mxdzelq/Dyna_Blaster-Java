package gfx;

import java.awt.image.BufferedImage;

/**
 * Klasa obsługująca i wczytująca wszystkie obrazy
 */

public class Assets {

    /**
     * Szerokość wycinka z arkusza
     */

    public static final int width=24;

    /**
     * Długość wycinka z arkusza
     */
    public static final int height=24;

    /**
     * Zmienna przechowująca obrazy, które nie wymagają animacji
     */

    public static BufferedImage brick,wall,enemy,bomb,grass;

    /**
     * Tablica przechowująca obrazy, które wymagają animacji
     */

    public static BufferedImage[] player_down, player_up, player_left, player_right;

    /**
     * Wczytanie wszystkich obrazów wykorzystywanych w grze
     */

    public static void init(){
    SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/img/sprites.png"));

    player_down=new BufferedImage[3];
    player_up=new BufferedImage[3];
    player_right=new BufferedImage[3];
    player_left=new BufferedImage[3];

    player_down[0]=sheet.crop(0,0,width,height);
    player_down[1]=sheet.crop(24,0,width,height);
    player_down[2]=sheet.crop(48,0,width,height);

        player_up[0]=sheet.crop(216,0,width,height);
        player_up[1]=sheet.crop(240,0,width,height);
        player_up[2]=sheet.crop(264,0,width,height);

        player_right[0]=sheet.crop(72,0,width,height);
        player_right[1]=sheet.crop(96,0,width,height);
        player_right[2]=sheet.crop(120,0,width,height);

        player_left[0]=sheet.crop(144,0,width,height);
        player_left[1]=sheet.crop(168,0,width,height);
        player_left[2]=sheet.crop(192,0,width,height);



    brick=ImageLoader.loadImage("/img/block.png");
    wall=ImageLoader.loadImage("/img/wall.png");
    grass=ImageLoader.loadImage("/img/grass2.png");
    enemy=ImageLoader.loadImage("/img/enemy.png");
    bomb=sheet.crop(470,0,16,16);
    }
}
