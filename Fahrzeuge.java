import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fahrzeuge extends Actor {
    
    public String marke;
    public String color;
    public String startDirection;
    
    public GreenfootImage image;
    
    public int direction;
    public int speed;
    
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
    public void setStartDirection(String direction) { startDirection = direction; }
    //set/get direction
    public void setDirection(int rotation) { direction = rotation; }
    //set/get speed
    public void setSpeed(int number) { speed = number; }
    public int getSpeed() { return speed; }
    
    public void act() {
        // Add your action code here.
    }
}
