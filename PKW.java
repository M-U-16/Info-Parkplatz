import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PKW extends Fahrzeuge {
    
    public PKW(String imgPath, int slotPosition, int rotation) {
        
        setSprite(imgPath);
        image.scale(image.getWidth() - 20, image.getHeight() - 10);
        setWidth();
        setHeight();
        setSlotPosition(slotPosition);
        
        setImage(getSprite());
        setRotation(rotation);
    }
    public int getSlotPosition() { return slotPosition; }
    public void act() {
        
        movement();
        if (isAtEdge()) {
            System.out.print(direction);
            if (direction == 180) { setDirection(0); }
            else if (direction == 0) { setDirection(180); }
            update();
        }
        
    }
}
