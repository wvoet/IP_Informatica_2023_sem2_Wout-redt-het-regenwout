import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class homescreen extends World
{
    public Player player;
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
        Cleanwater cleanwater = new Cleanwater();
        addObject(cleanwater,1782,380);
        Lifeonland lifeonland = new Lifeonland();
        addObject(lifeonland,324,330);
        Peace peace = new Peace();
        addObject(peace,337,1858);
        Player player = new Player();
        addObject(player,250,300);
    }
}
