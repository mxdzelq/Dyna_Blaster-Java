package DynaBlaster;


import entities.*;

import java.awt.*;


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
        map = new Map(handler,1);
        handler.setMap(map);

    }
    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);

        Font fnt=new Font("arial",1,20);

        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawString("Życia: ",10,410);
        g.drawString(Integer.toString(EntityManager.getPlayer().getHealth()),70,410);
        g.drawString("Prędkość: ",120,410);
        g.drawString(Float.toString(EntityManager.getPlayer().getSpeed()),220,410);
        g.drawString("Wynik: ",270,410);
        g.drawString(Integer.toString(EntityManager.getPlayer().getScore()),335,410);
        g.drawString("Pozostały czas: ",385,410);
        g.drawString(Integer.toString(EntityManager.getPlayer().getTimeLeft()/1000),535,410);
    }


}
