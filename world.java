import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Parkplatz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class world extends World {
    
    public world() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        //setBackground("background.png");
        populate();
    }
    public void populate() {
        // Create Parkplatz
        Parkplatz parkplatz = new Parkplatz(this);
        int[] parkplatz_dimensions = parkplatz.getParkplatzDimensions();
        // adds new object in the world center
        addObject(parkplatz, getWidth() / 2, parkplatz_dimensions[1] / 2);
        //System.out.println("Test");
    }
}