import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkplatz extends Strukturen {
    
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
        setX(x);
        setY(y);
    }
    //get/set position
    public void setX(int x) { x_pos = x; }
    public void setY(int y) { y_pos = y; }
    public int getX() { return x_pos; }
    public int getY() { return y_pos; }
    //method for drawing the image of the parkplatz
    public void drawParkplatzImage() {
        parkplatz.setColor(new Color(140, 140, 140));
        parkplatz.fill();
        setImage(parkplatz);
    }
    //method for setting the size of the parkplatz
    public int[] getParkplatzDimensions() {
        return getDimensions(parkplatz);
    }
    //method for getting the top left corner as array
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
