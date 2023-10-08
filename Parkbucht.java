import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkbucht extends Strukturen {
    
    public int x_pos;
    public int y_pos;
    
    public GreenfootImage parkbuchtImage;
    public String slotText;
    public int slotNumber;
    
    public boolean showSlotNumber = true;
    
    public Parkbucht(int slot, boolean isFliped) {
        parkbuchtImage = new GreenfootImage("parkbucht.png");
        setImage(parkbuchtImage);
        setSlotNumber(slot);
        setSlotText(slot);
        setRotation(isFliped);
    }
    //get/set position
    public void setY(int y) { y_pos = y; }
    public void setX(int x) { x_pos = x; }
    public int getY() { return y_pos; };
    public int getX() { return x_pos; };
    
    //get/set slot number
    public void setSlotNumber(int slot) { slotNumber = slot; }
    public int getSlotNumber() { return slotNumber; };
    
    //get/set slot number text
    public void setSlotText(int slot) { slotText = String.valueOf(slot); }
    public String getSlotText() { return slotText; }
    
    // get/set parkbucht width height
    public int[] getParkbuchtDimensions() { return getDimensions(parkbuchtImage); }
    public void setParkbuchtDimensions(int width, int height) {
        parkbuchtImage.scale(width, height);
    }
    //set rotation
    public void setRotation(boolean isFliped) {
        if (isFliped) { setRotation(180); }
    }
    //act method
    public void act() {
        //display slot number
        this.getWorld().showText(slotText, x_pos, y_pos);
    }
}
