import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the river flow across the screen.
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class River extends Actor
{
    public void act()
    {
        RiverFlow();
    }
    
    public void RiverFlow()
    {
        //makes the river appear to flow on the screen
        setLocation(getX(), getY() + 1);
        if(getY() > 540){
            setLocation(405, 61);
        }
    }
}
