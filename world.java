import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class world extends World {
    
    private Parkplatz parkplatz;
    private int parkbuchtWidth = 90;
    private int parkbuchtHeight = 40;
    private int AMOUNT_OF_PARKBUCHTEN = 28;
    private int parkplatzMiddle = 60;
    private int AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 14;
    private int parkplatzWidth;
    private int parkplatzHeight;
    private int MAX_CARS = 10;
    
    public world() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        populate();
    }
    //---------------method for adding parkbuchten----------------------------------
    public void addParkbucht(int slotNumber, boolean isFliped) {
         
        int topLeft_x = parkplatz.getLeft();
        int topLeft_y = parkplatz.getTop();
        int offset_y = 0;
        
        //creating a new instance of parkbucht
        Parkbucht parkbucht = new Parkbucht(slotNumber, isFliped);
        //setting width and height of parkbucht instance
        parkbucht.scaleImage(parkbuchtWidth, parkbuchtHeight);
        //getting the dimensions for placing them later
        int parkbucht_width = parkbucht.getImageWidth();
        int parkbucht_height = parkbucht.getImageHeight();
        
        if (slotNumber <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) {
            offset_y = parkbucht_height * (slotNumber - 1);
        } else {
            offset_y = parkbucht_height * (slotNumber - 15);
        }
        
        //sets the x position according to the rotation state
        if (!isFliped) {
            parkbucht.setX(topLeft_x + parkbucht_width / 2);
        } else {
            parkbucht.setX(
                topLeft_x +
                parkplatz.getImageWidth() -
                parkbucht_width +
                parkplatzMiddle
            );
        }
        //sets the y position from top left parkplatz plus offset
        parkbucht.setY(topLeft_y + parkbucht.getImageHeight() / 2 + offset_y);
        //add the new parkbucht to the world
        addObject(parkbucht, parkbucht.getCurrentX(), parkbucht.getCurrentY());    
    }
    //---------------populate the world----------------------------------
    public void populate() {
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
        
        //---------------adding parkbuchten----------------------------------
        for (int i = 1; i <= AMOUNT_OF_PARKBUCHTEN; i++) {
            if (i <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, false); }
            if (i > AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, true); }
        }
        //---------------adding cars and mopeds----------------------------------
        //car image files
        String blackCar = "cars/black-car.png";
        String greenCar = "cars/green-car.png";
        String blueCar = "cars/blue-car.png";
        String whiteCar = "cars/car-white.png";
        String redCar = "cars/red-car.png";
        String silverCar = "cars/car-silber.png";
        String greyCar="cars/grey-car.png";
        //moped image files
        String longGreyMoped = "mopeds/moped-grau-lang.png";
        String yellowMoped = "mopeds/moped-yellow.png";
        String türkisMoped = "mopeds/moped-türkis.png";
        String blueMoped = "mopeds/moped-blue.png";
       
        int left = 180;
        int right = 0;
        //array for holding cars
        PKW[] cars = new PKW[20];
        cars[0] = new PKW(blueCar, 1, right); // filename, slotposition, oriantation
        cars[1] = new PKW(silverCar, 2, right);
        cars[2] = new PKW(blackCar, 3, left);
        cars[3] = new PKW(redCar, 4, left);
        cars[4] = new PKW(blackCar, 5, left);
        cars[5] = new PKW(greyCar, 6, left);
        cars[6] = new PKW(whiteCar, 7, left);
        cars[7] = new PKW(silverCar, 8, left);
        cars[8] = new PKW(blueCar, 9, left);
        cars[9] = new PKW(greyCar, 10, right);
        cars[10] = new PKW(whiteCar, 11, right);
        cars[11] = new PKW(redCar, 12, right);
        cars[12] = new PKW(redCar, 13, right);
        cars[13] = new PKW(greyCar, 14, right);
        cars[14] = new PKW(blueCar, 15, left);
        cars[15] = new PKW(greyCar, 16, left);
        cars[16] = new PKW(blueCar, 17, left);
        cars[17] = new PKW(blueCar, 19 ,right);
        cars[18] = new PKW(greyCar, 20, right);
        cars[19] = new PKW(silverCar, 21,right);
        //cycles through all parkbuchten an cars and if the slot number
        //matches its getting placed on the position of the parkbucht
        for (Parkbucht parkbucht : getObjects(Parkbucht.class)) {
            //for (PKW car : cars) {
            for (int i = 0; i < cars.length; i++) {
                int currentSlotNumber = parkbucht.getSlotNumber();
                
                if (cars[i] == null) {}
                else if (cars[i].getSlotPosition() == currentSlotNumber && i <= MAX_CARS) {
                    cars[i].setX(parkbucht.getCurrentX());
                    cars[i].setY(parkbucht.getCurrentY());
                    //add car on top off parkbucht
                    addObject(cars[i], cars[i].getCurrentX(), cars[i].getCurrentY());
                }   
            }
        }
    }
}