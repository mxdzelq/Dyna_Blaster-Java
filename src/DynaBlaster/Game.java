package DynaBlaster;

import gfx.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Klasa gry
 */

public class Game implements Runnable {

    /**
     * Obiekt wyświetlacza
     */

    private Display display;

    /**
     * Szerokość i wysokość okna
     */

    public int width,height;

    /**
     * Tytuł ramki aplikacji
     */

    public String title;

    /**
     * Sprawdzenie czy aplikacja jest uruchomiona
     */

    private boolean running=false;

    /**
     * Sprawdzenie pauzy
     */

    public static boolean paused=false;

    /**
     * Obiekt wątku
     */

    private Thread thread;

    /**
     * Obiekt typu BufferStrategy
     */

    private BufferStrategy bs;

    /**
     * Obiekt graficzny
     */

    private Graphics g;

    /**
     * Obiekt stanu gry
     */

    public State gameState;

    /**
     * Obiekt stanu menu
     */

    public State menuState;

    /**
     * Obiekt menedżera klawiszy
     */

    private KeyManager keyManager;

    /**
     * Obiekt menedżera myszki
     */

    private MouseManager mouseManager;

    /**
     * Obiekt obsługi zdarzeń
     */

    private Handler handler;

    /**
     * Konstruktor gry
     * @param title tytuł okna
     * @param width szerokość okna
     * @param height wysokość okna
     */

    public Game(String title, int width, int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager= new KeyManager(handler,this);
        mouseManager = new MouseManager();
    }

    /**
     * Inicjalizjacja gry
     */

    public void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler=new Handler(this);

        gameState=new GameState(handler);
        menuState=new MenuState(handler);
        State.setState(menuState);

    };

    /**
     * Aktualizacja stanu gry
     */

    private void update(){
        keyManager.update();
//System.out.println(display.getFrame().getWidth());

        if(!paused) {
            keyManager.update();
            if (State.getState() != null)
                State.getState().update();
        }
        if(paused) {
            keyManager.update();
        }
    }

    /**
     * Narysowanie stanu gry przy wykorzystaniu BufferStraregy renderującego 3 klatki
     */

    private void render(){
        bs=display.getCanvas().getBufferStrategy();
        if(bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);

        if(State.getState() !=null)
            State.getState().render(g);

        bs.show();
        g.dispose();
    }

    /**
     * Uruchomienie pętli gry działającej w 60fps aż do zatrzymania metodą stop
     */

    @Override
    public void run() {
    init();

        int fps = config.fps;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                delta--;
            }
        }

        stop();

    }

    /**
     * Start wątku
     */

    public synchronized void start(){
        if(running)
            return;
        running=true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Zatrzymanie pętli gry
     */

    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Thread getThread() {
        return thread;
    }

    public Display getDisplay() {
        return display;
    }
}
