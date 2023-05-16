import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bridge that gets broken when the player walks over it. The main objective of the level is
 * to repair it with the planks you collect from the river in phase 2.
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class bridge extends Actor
{
    //array of available sprites for the garbage actor
    private static final String[] imageFiles = {
        "bridge_destroyed_1.png",
        "bridge_destroyed_2.png",
        "bridge_destroyed_3.png",
        "bridge_destroyed_4.png",
        "bridge_destroyed_5.png",
        "bridge.png"
    };
    public void bridgeState(int state)
    {
        //sets the correct image for each state using an array
        setImage(imageFiles[state]);
    }
}
