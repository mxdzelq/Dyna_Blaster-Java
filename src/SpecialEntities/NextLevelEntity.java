package SpecialEntities;

import DynaBlaster.Handler;
import DynaBlaster.State;
import DynaBlaster.config;
import entities.EntityManager;
import entities.Player;
import gfx.Assets;
import tiles.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * Jednostka po kolizji z którą gracz przechodzi na kolejny poziom
 */

public class NextLevelEntity extends SpecialEntity {

    JFrame f;

    Player player= EntityManager.getPlayer();
    /**
     * Konstruktor jednostki specjalnej
     *
     * @param handler obsługa zdarzeń
     * @param x       położenie w płaszczyźnie x
     * @param y       położenie w płaszczyźnie y
     */
    public NextLevelEntity(Handler handler, float x, float y) {
        super(handler, x, y, Tile.DEFAULT_TILEWIDTH,Tile.DEFAULT_TILEHEIGHT);
    }

    @Override
    public void update() {
        if(checkCollisionWithPlayer(0f,0f))
            active=false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.nextLevelDoors,(int)(x),(int)(y),width,height,null);

    }

    public final boolean checkCollisionWithPlayer(float xOffset, float yOffset){
        if(getCollisionBounds(0f,0f).intersects(player.getCollisionBounds(xOffset,yOffset))){
            if(handler.getMap().getId()==1) {
                Player player2 = EntityManager.getPlayer();
                handler.getMap().getEntityManager().getEntities().clear();
                handler.getMap().getEntityManager().getEntities().add(player2);
                EntityManager.getPlayer().setSpeed(config.defaultPlayerSpeed);
                EntityManager.getPlayer().setX(config.playerSpawnX);
                EntityManager.getPlayer().setY(config.playerSpawnY);
                player2.setScore(player2.getScore()+config.pointsForPassingLevel);
                handler.getMap().setId(2);
                handler.getMap().loadEntities(config.level2);
                handler.getMap().loadMap(config.level2);
                return true;
            }
            if(handler.getMap().getId()==2) {
                Player player3 = EntityManager.getPlayer();
                handler.getMap().getEntityManager().getEntities().clear();
                handler.getMap().getEntityManager().getEntities().add(player3);
                EntityManager.getPlayer().setSpeed(config.defaultPlayerSpeed);
                EntityManager.getPlayer().setX(config.playerSpawnX);
                EntityManager.getPlayer().setY(config.playerSpawnY);
                player3.setScore(player3.getScore()+config.pointsForPassingLevel);
                handler.getMap().setId(3);
                handler.getMap().loadEntities(config.level3);
                handler.getMap().loadMap(config.level3);
                return true;
            }
            if(handler.getMap().getId()==3){
                EntityManager.getPlayer().setScore(EntityManager.getPlayer().getScore()+config.pointsForPassingLevel);
                EntityManager.getPlayer().setScore(EntityManager.getPlayer().getScore()+(EntityManager.getPlayer().getHealth()*config.pointsForLife));
                f=new JFrame();
                String name = JOptionPane.showInputDialog(f,"Twój wynik: "+ EntityManager.getPlayer().getScore() + "\n Podaj nick");
                EntityManager.getPlayer().setName(name);
                State.setState(handler.getGame().menuState);
            }

        }return false;
    }
}
