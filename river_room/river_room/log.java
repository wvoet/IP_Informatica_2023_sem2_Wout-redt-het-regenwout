import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * deals damage to player
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class log extends Actor
{
    /**
     * Act - applies the inRiver function
     */
    public void act()
    {
        inRiver();
    }
    
    public void inRiver()
    {
        //makes the log drift downstream
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
