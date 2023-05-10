import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the river flow across the screen.
 * 
 * @author Arno De Pauw 
 * @version V1.0.0
 */
public class River extends Actor
{
    public River river1;
    
    public void act()
    {
        RiverFlow();
    }

    public void RiverFlow()
    {
        setLocation(getX(), getY() + 1);
        if(getY() > 540){
            setLocation(405, 61);
        }
    }
}
