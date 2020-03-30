package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Klasa obsługująca wczytywanie obrazów
 */

public class ImageLoader {

    /**
     * wczytanie obrazu
     * @param path ścieżka do obrazu
     * @return wczytany obraz
     */
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
