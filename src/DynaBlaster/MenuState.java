package DynaBlaster;

import entities.EntityManager;

import javax.swing.*;
import java.awt.*;

/**
 * Stan menu
 */

public class MenuState extends State{

    /**
     * Konstruktor stanu menu
     * @param handler obsługa zdarzeń
     */

    public MenuState(Handler handler){
        super(handler);
        handler.getKeyManager();
    }
    @Override
    public void update() {
        int mx=handler.getMouseManager().getMouseX();
        int my=handler.getMouseManager().getMouseY();

        if(handler.getMouseManager().mouseOver(mx,my,250,20,150,50) && (handler.getMouseManager().isLeftPressed())) {
            State.setState(handler.getGame().gameState);
            EntityManager.getPlayer().setHealth(3);
            handler.getMouseManager().unpress();
        }

        if(handler.getMouseManager().mouseOver(mx,my,250,90,150,50) && (handler.getMouseManager().isLeftPressed())) {
            JOptionPane.showMessageDialog(null, config.rulesText);
            handler.getMouseManager().unpress();
        }

        if(handler.getMouseManager().mouseOver(mx,my,250,160,150,50) && (handler.getMouseManager().isLeftPressed())) {
            JOptionPane.showMessageDialog(null, "Najwyższe wyniki"+"\n"+"test");
            handler.getMouseManager().unpress();
        }

        if(handler.getMouseManager().mouseOver(mx,my,250,230,150,50) && (handler.getMouseManager().isLeftPressed())){
            System.exit(0);
            handler.getMouseManager().unpress();
        }


    }

    /**
     * Narysowanie przycisków w menu
     * @param g obiekt graficzny
     */

    @Override
    public void render(Graphics g) {
Font fnt=new Font("arial",1,30);


        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawRect(250,20,150,50);
        g.drawString("Nowa gra",255,55);

        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawRect(250,90,150,50);
        g.drawString("Zasady",275,125);

        Font fnt2=new Font("arial",1,20);

        g.setFont(fnt2);
        g.setColor(Color.black);
        g.drawRect(250,160,150,50);
        g.drawString("Najwyższe",275,180);
        g.drawString("wyniki",295,200);

        g.setFont(fnt);
        g.setColor(Color.black);
        g.drawRect(250,230,150,50);
        g.drawString("Wyjście",270,265);
    }




}
