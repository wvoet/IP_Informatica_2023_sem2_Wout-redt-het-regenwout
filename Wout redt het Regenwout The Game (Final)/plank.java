import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * can be collected by player
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class plank extends Actor
{
    //array of available sprites for the plank actor
    private static final String[] imageFiles = {
            "plank1.png",
            "plank2.png",
            "plank3.png",
            "plank4.png",
            "plank5.png",
            "plank6.png",
            "plank7.png",
            "plank8.png",
            "plank9.png",
            "plank10.png",
            "plank11.png"
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
        //chooses a random sprite for the plank using an array and random index, and scales it
        int randomIndex = Greenfoot.getRandomNumber(imageFiles.length);
        GreenfootImage randomImage = new GreenfootImage(imageFiles[randomIndex]);
        int newWidth = (int) (randomImage.getWidth() * 0.5);
        int newHeight = (int) (randomImage.getHeight() * 0.5);
        randomImage.scale(newWidth,newHeight);
        setImage(randomImage);
    }
    
    public void inRiver() 
    {
        //makes the planks drift downstream
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
