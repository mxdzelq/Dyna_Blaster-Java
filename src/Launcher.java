import DynaBlaster.Game;
import DynaBlaster.config;

/**
 * Klasa uruchamiająca program
 */

public class Launcher {

    public static void main(String[] args){
Game game = new Game(config.frameTitle,config.gameWindowWidth,config.gameWindowHeight);
game.start();

    }
}
