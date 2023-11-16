import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkbucht extends Strukturen {
    
    public String slotText;
    public int slotNumber;
    public boolean showSlotNumber = true;
    
    public Parkbucht(int slot, boolean isFliped) {
        super("parkbucht.png");
        setSlotNumber(slot);
        setSlotText(slot);
        setRotation(isFliped);
    }
    
    //get/set slot number
    public void setSlotNumber(int slot) { slotNumber = slot; }
    public int getSlotNumber() { return slotNumber; };
    
    //get/set slot number text
    public void setSlotText(int slot) { slotText = String.valueOf(slot); }
    public String getSlotText() { return slotText; }
    
    //set rotation
    public void setRotation(boolean isFliped) {
        if (isFliped) { setRotation(180); }
    }
    //act method
    public void act() {
        //display slot number
        if (showSlotNumber) {
            this.getWorld().showText(slotText, x_pos, y_pos);
        }
    }
}
