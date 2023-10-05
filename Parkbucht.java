import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Parkbucht extends Strukturen {
    
    public int[] position;
    public GreenfootImage parkbuchtImage;
    public String parkbuchtNumberText;
    
    public Parkbucht(int pos_x, int pos_y, int parkbuchtNumber) {
        setPosition(pos_x, pos_y);
        parkbuchtImage = new GreenfootImage("granit-light.jpg");
        parkbuchtNumberText = String.valueOf(parkbuchtNumber);
    }
    public void setPosition(int x, int y) {
        position[0] = x;
        position[1] = y;
    }
    public int[] getPosition() {
        return position;
    }
    public int[] getParkbuchtDimensions() {
        return getDimensions(parkbuchtImage);
    }
    public void scaleParkbucht(int width, int height) {
        parkbuchtImage.scale(width, height);
    }
    public void act() {
        // Add your action code here.
    }
}
