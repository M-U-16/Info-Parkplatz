import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PKW extends Fahrzeuge {   
    
    public PKW(String imgPath) {
        //super.setSpeed(speed);
        super.setSprite(imgPath);
        System.out.println(super.getSpeed());
        setImage(super.getSprite());
    }
    public void act() {
        // Add your action code here.
    }
}
