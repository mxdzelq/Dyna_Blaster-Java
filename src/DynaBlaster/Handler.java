package DynaBlaster;

/**
 * Klasa obsługi zdarzeń
 */

public class Handler {

    /**
     * Obiekt gry
     */

    private Game game;

    /**
     * Obiekt mapy
     */

    private Map map;

    /**
     * Konstruktor
     * @param game obiekt gry
     */

    public Handler(Game game){
    this.game=game;
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
