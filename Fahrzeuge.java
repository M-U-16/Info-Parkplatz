import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Fahrzeuge extends Actor {
    
    public String marke;
    public String color;
    public String startDirection;
    public int slotPosition;
    
    public GreenfootImage image;
    
    public int direction;
    public int speed;
    public int x_pos;
    public int y_pos;
    public int width;
    public int height;
    public boolean isIntersecting;
    
    public Fahrzeuge() {
    }
    //get/set image
    public void setSprite(String imgPath) { image = new GreenfootImage(imgPath); }
    public GreenfootImage getSprite() { return image; }
    
    //get/set marke
    public void setMarke(String name) { marke = name; }
    public String getMarke() { return marke; };
    
    //get/set color
    public void setColor(String Color) { color = Color; }
    public String getColor() { return color; }
    
    //set startDirection
    //public void setStartDirection(String direction) { startDirection = direction; }
    
    //set/get direction
    public void setDirection(int rotation) {
        direction = rotation;
        setRotation(direction);
    }
    public int getDirection() { return direction; }
    
    //set/get speed
    public void setSpeed(int number) { speed = number; }
    public int getSpeed() { return speed; }
    
    //get/set slotPosition
    public void setSlotPosition(int position) { slotPosition = position; }
    public int getSlotPosition() { return slotPosition; }
    
    //get/set x and y
    public void setY(int y) { y_pos = y; }
    public void setX(int x) { x_pos = x; }
    public int getCurrentX() { return x_pos; }
    public int getCurrentY() { return y_pos; }
    
    //set width and height
    public void setWidth() { width = image.getWidth(); }
    public void setHeight() { height = image.getHeight(); }
    
    public void update() {
        //setRotation(direction);
    }
    //generate random number for car speed
    public int generateRandomSpeed() {
        int randomSpeedInt = (int)(Math.random() * 4 + 2);
        return randomSpeedInt;
    }
    
    //better method for checking the collision with world borders
    public boolean checkEdge() {
        
        //check left edge
        if (getX() - width / 2 <= 0 && direction == 180) { return true; }
        //check right edge
        if (getX() + width / 2 >= this.getWorld().getWidth() && direction == 0) { return true; }
        
        //no collision with any border
        return false;
    }
    public void uTurn() {
        if (direction == 90) { setDirection(360); }
        else if (direction == 360) { setDirection(90); }
        else if (direction == 0) { setDirection(180); }
        else if (direction == 180) { setDirection(0); }
    }
    public void movement() {
        int distance = speed;
        if (isIntersecting) { distance = 2; }
        move(distance);
        
        if (checkEdge()) { uTurn(); }
    }
    public void act() {
        
    }
}
