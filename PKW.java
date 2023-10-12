import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PKW extends Fahrzeuge {   
    
    public PKW(String imgPath, int slotPosition) {
        //super.setSpeed(speed);
        super.setSprite(imgPath);
        super.setSlotPosition(slotPosition);
        //System.out.println(super.getSpeed());
        setImage(super.getSprite());
    }
    public int getSlotPosition() { return super.slotPosition; }
    public void act() {
        // Add your action code here.
    }
}
