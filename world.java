import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class world extends World {
    
    private int AMOUNT_OF_PARKBUCHTEN = 28;
    private int AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 14;
    private Parkplatz parkplatz;
    private int parkbuchtWidth = 90;
    private int parkbuchtHeight = 40;
    private int parkplatzMiddle = 60;
    private int parkplatzWidth;
    private int parkplatzHeight;
    
    public world() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        populate();
    }
    public void addCarParkplatz() {
        //---------------creating parkplatz----------------------------------
        parkplatzWidth = parkbuchtWidth * 2 + parkplatzMiddle;
        parkplatzHeight = parkbuchtHeight * AMOUNT_OF_PARKBUCHTEN_PER_SIDE;
        parkplatz = new Parkplatz(
            getWidth() / 2, //places the parkplatz on right side
            parkplatzHeight / 2 + 20, //centers the parkplatz vertical
            parkplatzWidth, //sets the width of the parkplatz
            parkplatzHeight //sets the height of the parkplatz
        );
        
        // adds new object in the world center
        addObject(parkplatz, parkplatz.getCurrentX(), parkplatz.getCurrentY());
    }
    //---------------populate the world----------------------------------
    public void populate() {
        addCarParkplatz();
        parkplatz.populate();
    }
}