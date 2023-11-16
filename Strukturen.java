import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Strukturen extends Actor {
    
    public int x_pos;
    public int y_pos;
    public GreenfootImage image;
    
    public Strukturen(String imgFile) {
        image = new GreenfootImage(imgFile);
        setImage(image);
    }
    
    //get/set position
    public void setY(int y) { y_pos = y; }
    public void setX(int x) { x_pos = x; }
    public int getCurrentY() { return y_pos; }
    public int getCurrentX() { return x_pos; }
    //scaling image width and height
    public void scaleImage(int width, int height) { image.scale(width, height); }
    // get width and height of structure image
    public int getImageWidth() { return image.getWidth(); }
    public int getImageHeight() { return image.getHeight(); }
    //methods for getting top and left sides of parkplatz
    public int getTop() { return y_pos - getImageHeight() / 2; }
    public int getBottom() { return y_pos + getImageHeight() / 2; }
    public int getLeft() { return x_pos - getImageWidth() / 2; }
    public int getRight() { return x_pos + getImageWidth() / 2; }
    
    public void act() {}
}