package DynaBlaster;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Klasa obsługująca myszkę
 */

public class MouseManager implements MouseMotionListener, MouseListener {

    /**
     * Sprawdzenie który przycisk myszy jest wciśnięty
     */

    private boolean leftPressed,rightPressed;

    /**
     * Położenie kursora w płaszczyźnie x i y
     */

    private int mouseX,mouseY;

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void unpress(){
        leftPressed=false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /**
     * Sprawdzenie czy położenie kursora znajduje się w określonych granicach
     * @param mx położenie kursora w płaszczyźnie x
     * @param my położenie kursora w płaszczyźnie y
     * @param x początek granicy w płaszczyźnie x
     * @param y początek granicy w płaszczyźnie y
     * @param width szerokość granicy
     * @param height wysokość granicy
     * @return zwrot czy kursor znajduje się w określonych granicach
     */

    public boolean mouseOver(int mx, int my, int x, int y, int width, int height){

if(mx>x && mx<x+width){
    if(my>y && my<y+height){
        return true;
    }else return false;
}else return false;
    }
}
