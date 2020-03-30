package DynaBlaster;

import gfx.Assets;
import entities.*;

import java.awt.*;

import static gfx.Assets.enemy;

/**
 * Klasa stanu gry
 */

public class GameState extends State{

    /**
     * Obiekt mapy
     */

    private Map map;

    /**
     * Konstruktor stanu gry
     * @param handler obsługa zdarzeń
     */

    public GameState(Handler handler){
        super(handler);
        map = new Map(handler);
        handler.setMap(map);
    }
    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
    }


}
