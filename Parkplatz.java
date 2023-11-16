import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkplatz extends Strukturen {
    
    public int PARKPLATZ_WIDTH;
    public int PARKPLATZ_HEIGHT;
    public GreenfootImage parkplatz;
    
    //constructor
    public Parkplatz(int x, int y, int width, int height) {
        super("parkbucht.png");
        PARKPLATZ_WIDTH = width;
        PARKPLATZ_HEIGHT = height;
        drawParkplatzImage();
        scaleImage(width, height);
        setX(x);
        setY(y);
    }
    //method for drawing the image of the parkplatz
    public void drawParkplatzImage() {
        image.setColor(new Color(140, 140, 140));
        image.fill();
        setImage(image);
    }
    //method for testing
    public void addParkbucht() {
        this.getWorld().addObject(new Parkbucht(11, false), 100, 100);
    }
    
    //act method
    public void act() {
    }
}
