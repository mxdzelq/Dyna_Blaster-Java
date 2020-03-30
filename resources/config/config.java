package config;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Klasa parsująca plik konfiguracyjny xml z javą
 */

public final class config {

    /**
     * Ścieżka do pliku konfiguracyjnego
     */

    public static final String xmlConfig = "resources/config/config.xml";

    /**
     * Ścieżka do pliku przechowującego poziomy
     */

    public static final String xmlLevels = "resources/config/levels.xml";

    /**
     * Wysokość okna gry
     */

    public static int gameWindowHeight;

    /**
     * Szerokość okna gry
     */

    public static int gameWindowWidth;

    /**
     * Liczba klatek na sekundę w których działa gra
     */

    public static int fps;

    /**
     * Tytuł okna aplikacji
     */

    public static String frameTitle;

    /**
     * Tekst zawierający zasady rozgrywki
     */

    public static String rulesText;

    /**
     * Tekst zawierający informacje o poziomach
     */

    public static String level1, level2, level3;

    /**
     * Szerokość poziomu(w blokach 32x32)
     */

    public static int levelWidth;

    /**
     * Długość poziomu(w blokach 32x32)
     */

    public static int levelHeight;

    /**
     * Miejsce odrodzenia gracza w płaszczyźnie x
     */

    public static int playerSpawnX;

    /**
     * Miejsce odrodzenia gracza w płaszczyźnie y
     */

    public static int playerSpawnY;

    /**
     * Początkowa prędkość gracza
     */

    public static float defaultPlayerSpeed;

    /**
     * Metoda parsująca plik config.xml z klasą java
     */

    static{
        parseConfig();
    }

    /**
     * Metoda parsująca plik levels.xml z klasą java
     */

    static{
        parseLevels();
    }

    private config(){}

    public static void parseConfig(){
        try{
            File xmlInputFile = new File(xmlConfig);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlInputFile);
            doc.getDocumentElement().normalize();

            gameWindowHeight=Integer.parseInt(doc.getElementsByTagName("gameWindowHeight").item(0).getTextContent());
            gameWindowWidth=Integer.parseInt(doc.getElementsByTagName("gameWindowWidth").item(0).getTextContent());
            frameTitle=doc.getElementsByTagName("frameTitle").item(0).getTextContent();
            rulesText=doc.getElementsByTagName("rulesText").item(0).getTextContent();
            fps=Integer.parseInt(doc.getElementsByTagName("defaultFps").item(0).getTextContent());
            defaultPlayerSpeed=Float.parseFloat(doc.getElementsByTagName("defaultPlayerSpeed").item(0).getTextContent());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    public static void parseLevels(){
        try{
            File xmlInputFileL = new File(xmlLevels);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document docL = dBuilder.parse(xmlInputFileL);
            docL.getDocumentElement().normalize();

            levelWidth=Integer.parseInt(docL.getElementsByTagName("levelwidth").item(0).getTextContent());
            levelHeight=Integer.parseInt(docL.getElementsByTagName("levelheight").item(0).getTextContent());
            playerSpawnX=Integer.parseInt(docL.getElementsByTagName("playerSpawnX").item(0).getTextContent());
            playerSpawnY=Integer.parseInt(docL.getElementsByTagName("playerSpawnY").item(0).getTextContent());
            level1=docL.getElementsByTagName("level1").item(0).getTextContent();
            level2=docL.getElementsByTagName("level2").item(0).getTextContent();
            //level3=docL.getElementsByTagName("level3").item(0).getTextContent();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
