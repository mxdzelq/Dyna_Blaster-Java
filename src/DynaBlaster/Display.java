package DynaBlaster;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa okna
 */

public class Display {
    /**
     * Ramka okna
     */

    private JFrame frame;

    /**
     * Miejsce rysowania obiektów graficznych
     */

    private Canvas canvas;

    /**
     * Tytuł ramki
     */

    private String title;

    /**
     * Szerokość i wysokość ramki
     */

    private int width, height;

    /**
     * Konstruktor okna
     * @param title tytuł ramki
     * @param width szerokość ramki
     * @param height wysokość ramki
     */

    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;

        createDisplay();
    }

    /**
     * Stworzenie okna
     */

    private void createDisplay(){
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

    public int getWidth() {
        return width;
    }
}
