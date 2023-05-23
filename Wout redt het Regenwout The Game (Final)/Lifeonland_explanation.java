import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lifeonland_explanation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lifeonland_explanation extends Actor
{
    /**
     * Act - do whatever the lifeonland wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        textaway();
    }

    public void textaway(){
        if (Greenfoot.isKeyDown("x"))
        {
            getWorld().removeObject(getWorld().getObjects(Lifeonland_explanation.class).get(0));
        }
    }
}
