package DynaBlaster;

import java.awt.*;

/**
 * Klasa obsługująca stany aplikacji
 */

public abstract class State {

    /**
     * Aktualny stan
     */

    private static State currentState=null;

    /**
     * Obsługa zdarzeń
     */

    protected Handler handler;

    /**
     * Zmiana stanu
     * @param state aktualny stan
     */

    public static void setState(State state){
        currentState=state;
    }

    /**
     * Konstruktor stanu
     * @param handler obsługa zdarzeń
     */

    public State(Handler handler){
        this.handler=handler;
    }

    public static State getState(){
        return currentState;
    }


    public abstract void update();

    public abstract void render(Graphics g);
}
