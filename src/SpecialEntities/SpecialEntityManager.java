package SpecialEntities;

import DynaBlaster.Handler;
import entities.Entity;

import java.awt.*;
import java.util.ArrayList;

/**
 * Zarządzanie jednostkami specjalnymi
 */

public class SpecialEntityManager {
    /**
     * Obsługa zdarzeń
     */
    private Handler handler;

    /**
     * Lista jednostek specjalnych
     */

    private static ArrayList<SpecialEntity> specialEntities;

    /**
     * Konstruktor obsługi jendostek specjalnych
     * @param handler obsługa zdarzeń
     */
    public SpecialEntityManager(Handler handler){
        this.handler=handler;
        specialEntities=new ArrayList<SpecialEntity>();
    }

    /**
     * Aktualizacja stanu jednostke
     */

    public void update(){
        for(int i=0;i<specialEntities.size();i++){
            SpecialEntity se=specialEntities.get(i);
            se.update();
            if(!se.isActive())
                specialEntities.remove(se);
        }
    }

    /**
     * Narysowanie stanu jednostek specjalnych
     * @param g obiekt graficzny
     */

    public void render(Graphics g){
        for(SpecialEntity se:specialEntities){
            se.render(g);
        }
    }

    public static ArrayList<SpecialEntity> getSpecialEntities() {
        return specialEntities;
    }

    public void addSpecialEntity(SpecialEntity se){
        specialEntities.add(se);
    }
}
