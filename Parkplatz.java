import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkplatz extends Strukturen {
    
    private int parkplatzWidth;
    private int parkplatzHeight;
    private GreenfootImage parkplatz;
    private int SPEED_LIMIT = 3;
    private int AMOUNT_OF_PARKBUCHTEN = 28;
    private int AMOUNT_OF_PARKBUCHTEN_PER_SIDE = 14;
    private int parkbuchtWidth = 90;
    private int parkbuchtHeight = 40;
    private int parkplatzMiddle = 60;
    private int MAX_CARS = 20;
    
    //car images paths
    private String blackCar = "cars/black-car.png";
    private String greenCar = "cars/green-car.png";
    private String blueCar = "cars/blue-car.png";
    private String whiteCar = "cars/white-car.png";
    private String redCar = "cars/red-car.png";
    private String silverCar = "cars/silber-car.png";
    private String greyCar="cars/grey-car.png";
    //moped images paths
    private String longGreyMoped = "mopeds/moped-grau-lang.png";
    private String yellowMoped = "mopeds/moped-yellow.png";
    private String türkisMoped = "mopeds/moped-türkis.png";
    private String blueMoped = "mopeds/moped-blue.png";
    
    public Parkplatz(int x, int y, int width, int height) {
        super("parkbucht.png"); // random default image
        parkplatzWidth = width;
        parkplatzHeight = height;
        drawParkplatzImage(); //changes default image
        scaleImage(width, height);
        setX(x);
        setY(y);
    }
    //sets Parkplatz width and height
    public void setParkplatzWidth(int width) { parkplatzWidth = width; }
    public void setParkplatzHeight(int height) { parkplatzHeight = height; }
    //get for speed limit
    public int getSpeedLimit() { return SPEED_LIMIT; }
    //method for drawing the image of the parkplatz
    public void drawParkplatzImage() {
        image.setColor(new Color(140, 140, 140));
        image.fill();
        setImage(image);
    }
    //---------------method for getting all cars-------------------------------------------
    public PKW[] getCars() {
        int left = 180;
        int right = 0;
        //array for holding cars
        PKW[] cars = new PKW[20];
        
        cars[0] = new PKW(blueCar, 1, right); // filename, slotposition, oriantation
        cars[1] = new PKW(silverCar, 2, right);
        cars[2] = new PKW(blackCar, 3, left);
        cars[3] = new PKW(redCar, 4, left);
        cars[4] = new PKW(blackCar, 5, left);
        cars[5] = new PKW(silverCar, 6, left);
        cars[6] = new PKW(whiteCar, 7, left);
        cars[7] = new PKW(silverCar, 8, left);
        cars[8] = new PKW(blueCar, 9, left);
        cars[9] = new PKW(silverCar, 10, right);
        cars[10] = new PKW(whiteCar, 11, right);
        cars[11] = new PKW(redCar, 12, right);
        cars[12] = new PKW(redCar, 13, right);
        cars[13] = new PKW(silverCar, 14, left);
        cars[14] = new PKW(blueCar, 15, left);
        cars[15] = new PKW(silverCar, 16, left);
        cars[16] = new PKW(blueCar, 17, left);
        cars[17] = new PKW(blueCar, 19 ,right);
        cars[18] = new PKW(silverCar, 20, right);
        cars[19] = new PKW(silverCar, 21,right);
        return cars;
    }
    //---------------method for adding a single parkbucht----------------------------------
    public void addParkbucht(int slotNumber, boolean isFliped) {
         
        int topLeft_x = getLeft();
        int topLeft_y = getTop();
        int offset_y = 0;
        
        //creating a new instance of the parkbucht class
        Parkbucht parkbucht = new Parkbucht(slotNumber, isFliped);
        //setting width and height of parkbucht instance
        parkbucht.scaleImage(parkbuchtWidth, parkbuchtHeight);
        //getting the dimensions for placing them later
        int parkbucht_width = parkbucht.getImageWidth();
        int parkbucht_height = parkbucht.getImageHeight();
        
        if (slotNumber <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) {
            offset_y = parkbucht_height * (slotNumber - 1);
        } else {
            offset_y = parkbucht_height * (slotNumber - AMOUNT_OF_PARKBUCHTEN_PER_SIDE -1);
        }
        
        //sets the x position according to the rotation state
        if (!isFliped) {
            parkbucht.setX(topLeft_x + parkbucht_width / 2);
        } else {
            parkbucht.setX(
                topLeft_x +
                getImageWidth() -
                parkbucht_width +
                parkplatzMiddle
            );
        }
        //sets the y position from top left parkplatz plus offset
        parkbucht.setY(topLeft_y + parkbucht.getImageHeight() / 2 + offset_y);
        //add the new parkbucht to the world
        this.getWorld().addObject(parkbucht, parkbucht.getCurrentX(), parkbucht.getCurrentY());    
    }
    public void addCars(PKW cars[]) {
        //cycles through all parkbuchten an cars and if the slot number
        //matches its getting placed on the position of the parkbucht
        for (Parkbucht parkbucht : this.getWorld().getObjects(Parkbucht.class)) {
            //for (PKW car : cars) {
            for (int i = 0; i < cars.length; i++) {
                int currentSlotNumber = parkbucht.getSlotNumber();
                
                if (cars[i] == null) {}
                else if (cars[i].getSlotPosition() == currentSlotNumber && i <= MAX_CARS) {
                    cars[i].setX(parkbucht.getCurrentX());
                    cars[i].setY(parkbucht.getCurrentY());
                    //add car on top off parkbucht
                    this.getWorld().addObject(
                        cars[i],
                        cars[i].getCurrentX(), cars[i].getCurrentY()
                    );
                }
            }
        }
    }
    //method for populating the parkplatz
    public void populate() {
        //---------------adding parkbuchten----------------------------------
        for (int i = 1; i <= AMOUNT_OF_PARKBUCHTEN; i++) {
            if (i <= AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, false); }
            if (i > AMOUNT_OF_PARKBUCHTEN_PER_SIDE) { addParkbucht(i, true); }
        }        
        this.addCars(this.getCars());
    }
    //public void act() {}
}
