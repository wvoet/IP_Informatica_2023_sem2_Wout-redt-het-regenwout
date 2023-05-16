import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Deals damage to player.
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class toxicWaste extends Actor
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
        //makes the waste drift downstream
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

