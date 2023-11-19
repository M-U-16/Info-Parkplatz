import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PKW extends Fahrzeuge {
    
    public PKW(String imgPath, int slotPosition, int rotation) {
        
        setSprite(imgPath);
        setWidth();
        setHeight();
        setSlotPosition(slotPosition);
        
        setImage(getSprite());
        setDirection(rotation);
        setSpeed(generateRandomSpeed());
    }
    public int getSlotPosition() { return slotPosition; }
    public void checkCarCollision() {
        this.removeTouching(PKW.class);
    }
    public void destroyCar() {
        this.getWorld().removeObject(this);
    }
    public void act() {
        //check if car is colliding with other cars
        checkCarCollision();
        //check if car is intersecting with parkplatz
        isIntersecting = getOneIntersectingObject(Parkplatz.class) != null;
        movement();
        //update();
    }
}
