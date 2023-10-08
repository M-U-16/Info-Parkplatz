import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkplatz extends Strukturen {
    //varibales
    public int PARKPLATZ_WIDTH;
    public int PARKPLATZ_HEIGHT;
    public GreenfootImage parkplatz;
    public int x_pos;
    public int y_pos;
    
    //constructor
    public Parkplatz(int x, int y, int width, int height) {
        PARKPLATZ_WIDTH = width;
        PARKPLATZ_HEIGHT = height;
        parkplatz = new GreenfootImage(PARKPLATZ_WIDTH, PARKPLATZ_HEIGHT);
        drawParkplatzImage();
        setPosition(x, y);
    }
    //method for drawing the image of the parkplatz
    public void drawParkplatzImage() {
        parkplatz.setColor(new Color(140, 140, 140));
        parkplatz.fill();
        setImage(parkplatz);
    }
    //get/set position
    public void setPosition(int x, int y) {
        x_pos = x;
        y_pos = y;
    }
    public int[] getPosition() {
        int[] position = {x_pos, y_pos};
        return position;
    }
    //method for setting the size of the parkplatz
    public int[] getParkplatzDimensions() {
        return getDimensions(parkplatz);
    }
    //method for getting the top left corner
    public int[] getTopLeft() {
        int[] topLeft = {
            x_pos - PARKPLATZ_WIDTH / 2,
            y_pos - PARKPLATZ_HEIGHT / 2
        };    
        return topLeft;
    }
    //method for testing
    public void addNewObjectFromParkplatz() {
        this.getWorld().addObject(new Parkbucht(11, false), 100, 100);
    }
    
    //act method
    public void act() {
    }
}
