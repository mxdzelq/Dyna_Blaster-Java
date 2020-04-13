package entities;

import DynaBlaster.Handler;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa obsługująca wszystkie jednostki
 */

public class EntityManager {

    /**
     * Obsługa zdarzeń
     */

    private Handler handler;

    /**
     * Obiekt gracza
     */

    private static Player player;

    /**
     * Obiekt przeciwnika
     */
    private Enemy enemy;

    /**
     * Lista wszystkich jednostek
     */
    private ArrayList<Entity> entities;

    /**
     * Konstruktor obsługi jednostek
     * @param handler obsługa zdarzeń
     * @param player gracz
     */

    public EntityManager(Handler handler, Player player){
    this.handler=handler;
    this.player=player;
    entities=new ArrayList<Entity>();
    addEntity(player);
    }

    /**
     * Aktualizacja stanu jednostek
     */

    public void update(){
    for(int i=0;i<entities.size();i++){
        Entity e=entities.get(i);
        e.update();
        if(!e.isActive())
            entities.remove(e);
    }
    }

    /**
     * Narysowanie stanu jednostek
     * @param g obiekt graficzny jednostki
     */

    public void render(Graphics g){
        for(Entity e:entities){
            e.render(g);
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void clearEntities(){
        for(int i=0;i<entities.size();i++){
            Entity e=entities.get(i);
                entities.remove(e);
                e.update();
        }
    }


    public static Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


}
