import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class homescreenn extends World
{

    /**
     * Constructor for objects of class homescreen.
     * 
     */
    public homescreenn()
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
        peace peace = new peace();
        addObject(peace,329,1721);
        peace.setLocation(444,1745);
        lifeonland lifeonland = new lifeonland();
        addObject(lifeonland,1613,325);
        cleanwater cleanwater = new cleanwater();
        addObject(cleanwater,1700,1628);
        peace.setLocation(277,1618);
        peace.setLocation(372,1692);
        peace.setLocation(342,1671);
        peace.setLocation(453,1768);
        peace.setLocation(322,1808);
        peace.setLocation(385,1728);
        peace.setLocation(335,1776);
        peace.setLocation(198,1772);
        peace.setLocation(336,1789);
    }
}

