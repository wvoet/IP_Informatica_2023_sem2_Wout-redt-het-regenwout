import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class toxicWaste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class toxicWaste extends Actor
{
    /**
     * Act - do whatever the toxicWaste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // same mechanics as garbage, but deals damage insted of being able to be picked up
        inRiver();
    }
    
    public void inRiver()
    {
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

