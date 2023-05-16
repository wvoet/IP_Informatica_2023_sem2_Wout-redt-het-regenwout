import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * can be collected by player
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class garbage extends Actor
{
    //array of available sprites for the garbage actor
    private static final String[] imageFiles = {
        "trashbag.png",
        "plastic_bag.png",
        "rusty_can.png",
        "old_tire.png",
        "broken_bottle.png",
        "beverage_can.png",
        "oil_barrel.png"
    };
    /**
     * applies the inRiver function
     */
    public void act()
    {
        inRiver();
    }
    
    public void randomise()
    {
        //chooses a random sprite for the garbage using an array and a random index
        int randomIndex = Greenfoot.getRandomNumber(imageFiles.length);
        setImage(imageFiles[randomIndex]);
    }
    
    public void inRiver()
    {
        //makes the garbage drift downstream
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }        
    }
}
