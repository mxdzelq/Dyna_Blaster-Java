package DynaBlaster;

import java.awt.event.*;

/**
 * Klasa obsługująca klawisze
 */

public class KeyManager implements KeyListener{

    /**
     * Tablica klawiszy
     */

    private boolean[] keys;

    /**
     * Klawisze ruchu gracza
     */

    public boolean up,down,left,right;

    /**
     * Klawisz postawienia bomby
     */

    public boolean bombPlace;

    /**
     * Klawisze pauzy i odpauzowania
     */

    public boolean pause,unpause;

    /**
     * Obiekt gry
     */

    Game game;

    /**
     * Obiekt obsługi zdarzeń
     */

    Handler handler;


    /**
     * Konstruktor obsługi klawiszy
     * @param handler obsługa zdarzeń
     * @param game obiekt gry
     */

    public KeyManager(Handler handler,Game game){
        this.game=game;
        this.handler=handler;
        keys = new boolean[256];
    }

    public void update(){
        up=keys[KeyEvent.VK_W];
        down=keys[KeyEvent.VK_S];
        left=keys[KeyEvent.VK_A];
        right=keys[KeyEvent.VK_D];
        bombPlace=keys[KeyEvent.VK_SPACE];
        pause=keys[KeyEvent.VK_P];
        unpause=keys[KeyEvent.VK_O];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;

        if(keys[e.getKeyCode()]==pause){
            Game.paused=true;
        }
        if(keys[e.getKeyCode()]==unpause){
            Game.paused=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }


}
