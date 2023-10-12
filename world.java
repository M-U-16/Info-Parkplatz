import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class world extends World {
    
    private Parkplatz parkplatz;
    private int parkbuchtWidth = 100;
    private int parkbuchtHeight = 45;
    private int AMOUNT_OF_PARKBUCHTEN = 20;
    private int AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 10;
    private int parkplatzWidth;
    private int parkplatzHeight;
    
    //private PKW[] cars = new PKW[20];
    //private Moped[] mopeds = new Moped[5];
    
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
            parkbucht.setX(topLeft_x + parkplatz.getParkplatzDimensions()[0] - parkbuchtDimensions[0] + 50);
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
        addObject(parkplatz, parkplatz.getX(), parkplatz.getY());
        
        //adds as many parkbuchten as needed
        for (int i = 1; i <= AMOUNT_OF_PARKBUCHTEN; i++) {
            if (i <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, false); }
            if (i > AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, true); }
        }
        //adding cars and mopeds
        //car image files
        String blackCar = "black-car.png";
        String greenCar = "green-car.png";
        String blueCar = "blue-car.png";
        String whiteCar = "white-car.png";
        String redCar = "red-car.png";
        
        //addObject(new PKW(blueCar, 0), 100, 100);
        //addObject(new Moped(5), 20, 20);
        
        PKW[] cars = new PKW[19];
        cars[0] = new PKW(blackCar, 1);
        cars[1] = new PKW(greenCar, 2);
        cars[2] = new PKW(blackCar, 3);
        cars[3] = new PKW(blackCar, 4);
        cars[4] = new PKW(blackCar, 5);
        cars[5] = new PKW(blackCar, 6);
        cars[6] = new PKW(blackCar, 7);
        cars[7] = new PKW(whiteCar, 8);
        cars[8] = new PKW(blackCar, 9);
        cars[9] = new PKW(blueCar, 10);
        cars[10] = new PKW(blueCar, 11);
        cars[11] = new PKW(blueCar, 12);
        cars[12] = new PKW(blueCar, 13);
        cars[13] = new PKW(blueCar, 14);
        cars[14] = new PKW(blueCar, 15);
        cars[15] = new PKW(blueCar, 16);
        cars[16] = new PKW(blueCar, 17);
        
        
        //System.out.print(getObjects(Parkbucht.class));
        for (Parkbucht i : getObjects(Parkbucht.class)) {
            //System.out.print(i.getX());
            //System.out.println(i.getY());
            //System.out.println(i.getSlotNumber());
            for (PKW car : cars) {
                if (car == null) {}
                else if (car.getSlotPosition() == i.getSlotNumber() ) {
                    car.setX(i.getX());
                    car.setY(i.getY());
                    System.out.println(car.getX() + " " + car.getY());
                    addObject(car, car.getX(), car.getY());
                }
            }
        }
    }
}