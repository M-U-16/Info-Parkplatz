import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Parkplatz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parkplatz extends Strukturen {
    //varibales
    public int PARKPLATZ_WIDTH;
    public int PARKPLATZ_HEIGHT;
    
    public int AMOUNT_OF_PARKBUCHTEN;
    public int AMOUNT_OF_PARKBUCHTEN_PER_SIDE;
    
    public GreenfootImage parkplatz;
    
    //constructor
    public Parkplatz(World world) {
        PARKPLATZ_WIDTH = 250;
        PARKPLATZ_HEIGHT = 400;
        
        AMOUNT_OF_PARKBUCHTEN = 28;
        AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 14;
        
        parkplatz = new GreenfootImage(PARKPLATZ_WIDTH, PARKPLATZ_HEIGHT);
        drawParkplatzImage();
        
        //System.out.println("Width: " + getParkplatzDimensions()[0] + "\n" + "Height: " + getParkplatzDimensions()[1]);
        
    }
    //method for drawing the image of the parkplatz
    public void drawParkplatzImage() {
        parkplatz.setColor(new Color(140, 140, 140));
        parkplatz.fill();
        setImage(parkplatz);
    }
    //method for getting the size of the parkplatz
    public int[] getParkplatzDimensions() {
        return getDimensions(parkplatz);
    }
    //adding a parkbucht
    public void addParkbucht() {
        Parkbucht parkbucht = new Parkbucht(100, 100, 1);
        World w = getWorld();
        w.addObject(parkbucht, 0, 0);
    }
    //act method
    public void act() {
    }
}
