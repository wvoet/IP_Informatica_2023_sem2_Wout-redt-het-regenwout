import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class homescreen extends World
{

    /**
     * Constructor for objects of class homescreen.
     * 
     */
    public homescreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(2048, 2048, 1); 
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        cleanwater cleanwater = new cleanwater();
        addObject(cleanwater,1782,380);
        lifeonland lifeonland = new lifeonland();
        addObject(lifeonland,324,330);
        peace peace = new peace();
        addObject(peace,337,1858);
    }
}
