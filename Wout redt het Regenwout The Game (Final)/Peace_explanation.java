import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class peace_explanation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peace_explanation extends Actor
{
    /**
     * Act - do whatever the peace_explanation wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        textaway();
    }

    public void textaway(){
        if (Greenfoot.isKeyDown("x"))
        {
            getWorld().removeObject(getWorld().getObjects(Peace_explanation.class).get(0));
        }
    }
}
