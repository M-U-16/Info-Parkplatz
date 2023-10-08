import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class world extends World {
    
    public Parkplatz parkplatz;
    public int parkplatzWidth;
    public int parkplatzHeight;
    
    public int parkbuchtWidth = 100;
    public int parkbuchtHeight = 45;
    
    public int AMOUNT_OF_PARKBUCHTEN = 20;
    public int AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 10;
    
    public world() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        //setBackground("background.png");
        populate();
    }
    public void addParkbucht(int slotNumber, boolean isFliped) {
        int topLeft_x;
        int topLeft_y;
        int offset_y;
        
        topLeft_x = parkplatz.getTopLeft()[0];
        topLeft_y = parkplatz.getTopLeft()[1];
        offset_y = 0;
        
        //creating a new instance of parkbucht
        Parkbucht parkbucht = new Parkbucht(slotNumber, isFliped);
        //setting width and height of parkbucht instance
        parkbucht.setParkbuchtDimensions(parkbuchtWidth, parkbuchtHeight);
        //getting the dimensions for later placing
        int[] parkbuchtDimensions = parkbucht.getParkbuchtDimensions();
        
        if (slotNumber <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) {
            offset_y = parkbuchtDimensions[1] * (slotNumber - 1);
        } else {
            offset_y = parkbuchtDimensions[1] * (slotNumber - 11);
        }
        
        //sets the x position according to the rotation state
        if (!isFliped) {
            parkbucht.setX(topLeft_x + parkbuchtDimensions[0] / 2);
        } else {
            parkbucht.setX(topLeft_x + parkplatzWidth - parkbuchtDimensions[0] + 50);
        }
        //sets the y position from top left parkplatz plus offset
        parkbucht.setY(topLeft_y + parkbuchtDimensions[1] / 2 + offset_y);
        
        //add the new parkbucht to the world
        addObject(parkbucht, parkbucht.getX(), parkbucht.getY());
        
    }
    public void populate() {
        // Create Parkplatz
        parkplatzWidth = parkbuchtWidth * 2 + 50;
        parkplatzHeight = parkbuchtHeight * AMOUNT_OF_PARKBUCHTEN_PER_SIDE;
        parkplatz = new Parkplatz(
            getWidth() - parkplatzWidth / 2, //places the parkplatz on right side
            getHeight() / 2, //centers the parkplatz vertical
            parkplatzWidth, //sets the width of the parkplatz
            parkplatzHeight //sets the height of the parkplatz
        );
        int[] parkplatz_dimensions = parkplatz.getParkplatzDimensions();
        // adds new object in the world center
        addObject(parkplatz, parkplatz.getPosition()[0], parkplatz.getPosition()[1]);
        
        //adds as many parkbuchten as needed
        for (int i = 1; i <= AMOUNT_OF_PARKBUCHTEN; i++) {
            if (i <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, false); }
            if (i > AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, true); }
        }
    }
}