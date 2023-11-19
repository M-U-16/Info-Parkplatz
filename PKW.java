import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PKW extends Fahrzeuge {
    
    public PKW(String imgPath, int slotPosition, int rotation) {
        
        setSprite(imgPath);
        setWidth();
        setHeight();
        setSlotPosition(slotPosition);
        
        setImage(getSprite());
        direction = rotation;
        update();
    }
    public int getSlotPosition() { return slotPosition; }
    public void act() {
        //check if car is intersecting with parkplatz
        isIntersecting = getOneIntersectingObject(Parkplatz.class) != null;
        movement();
        update();
    }
}
