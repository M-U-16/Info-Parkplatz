import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Fahrzeuge extends Actor {
    
    public String marke;
    public String color;
    public String startDirection;
    public int slotPosition;
    public Random random = new Random();
    
    public GreenfootImage image;
    
    public int direction;
    public int speed;
    
    public int x_pos;
    public int y_pos;
    
    public int width;
    public int height;
    
    public Fahrzeuge() {
        setSpeed(generateRandomSpeed());
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
    public void setStartDirection(String direction) { startDirection = direction; }
    
    //set/get direction
    public void setDirection(int rotation) { direction = rotation; }
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
    public int getX() { return x_pos; }
    public int getY() { return y_pos; }
    
    //set width and height
    public void setWidth() { width = image.getWidth(); }
    public void setHeight() { height = image.getHeight(); }
    
    public void update() { setRotation(direction); }
    public int generateRandomSpeed() { return random.nextInt(2, 6); }
    
    public boolean checkEdge() {
        //check left edge
        if (x_pos + width / 2 <= 0) { return true; }
        return true;
    }
    
    public void movement() {
        int distance = speed;
        move(distance);
    }
    
    public void act() {}
}
