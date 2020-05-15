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

    public static BufferedImage brick,wall,grass,speedUp,nextLevelDoors,fireBoost;

    /**
     * Tablica przechowująca obrazy, które wymagają animacji
     */

    public static BufferedImage[] player_down, player_up, player_left, player_right;

    /**
     * Animacja wybuchu bomby
     */

    public static BufferedImage[] bomb_boom;

    /**
     * Animacja wroga
     */

    public static BufferedImage[] enemyAnim;

    /**
     * Animacja ognia
     */

    public static BufferedImage[] fireRight,fireLeft,fireUp,fireDown;

    /**
     * Wczytanie wszystkich obrazów wykorzystywanych w grze
     */

    public static void init(){
    SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/img/sprites.png"));

    player_down=new BufferedImage[3];
    player_up=new BufferedImage[3];
    player_right=new BufferedImage[3];
    player_left=new BufferedImage[3];

    bomb_boom=new BufferedImage[7];

    fireRight=new BufferedImage[4];
    fireLeft=fireRight;
    fireUp=new BufferedImage[4];
    fireDown=fireUp;

    enemyAnim=new BufferedImage[3];

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

        bomb_boom[0]=sheet.crop(470,0,16,16);
        bomb_boom[1]=sheet.crop(486,0,16,16);
        bomb_boom[2]=sheet.crop(502,0,16,16);
        bomb_boom[3]=sheet.crop(390,32,16,16);
        bomb_boom[4]=sheet.crop(406,32,16,16);
        bomb_boom[5]=sheet.crop(422,32,16,16);
        bomb_boom[6]=sheet.crop(438,32,16,16);

        fireRight[0]=sheet.crop(326,32,16,16);
        fireRight[1]=sheet.crop(342,32,16,16);
        fireRight[2]=sheet.crop(358,32,16,16);
        fireRight[3]=sheet.crop(374,32,16,16);

        fireUp[0]=sheet.crop(582,16,16,16);
        fireUp[1]=sheet.crop(598,16,16,16);
        fireUp[2]=sheet.crop(614,16,16,16);
        fireUp[3]=sheet.crop(630,16,16,16);


        enemyAnim[0]=sheet.crop(394,233,16,16);
        enemyAnim[1]=sheet.crop(410,233,16,16);
        enemyAnim[2]=sheet.crop(426,233,16,16);

    brick=ImageLoader.loadImage("/img/block.png");
    wall=ImageLoader.loadImage("/img/wall.png");
    grass=ImageLoader.loadImage("/img/grass2.png");
    speedUp=ImageLoader.loadImage("/img/iSpeed.png");
    nextLevelDoors=ImageLoader.loadImage("/img/doors.png");
    fireBoost=ImageLoader.loadImage("/img/iFire.png");
    }
}
