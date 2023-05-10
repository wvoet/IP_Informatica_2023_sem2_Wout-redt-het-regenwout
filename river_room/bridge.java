import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The bridge that gets broken when the player walks over it. The main objective of the level is
 * to repair it with the planks you collect from the river in phase 2.
 * 
 * @arnodepauw
 * @V0.0.1
 */
public class bridge extends Actor
{
    public bridge dridge1;
    /**
     * Act - tracks the ammount of planks collected, and what the current state
     * of the bridge should be. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void bridgeState(int state)
    {
        //bridge needs to be scaled; NOT WORKING
        GreenfootImage image = getImage();
        int scaledHeight = image.getHeight()/4;
        int scaledWidth = image.getWidth()/4;
        image.scale(scaledWidth, scaledHeight);
        //checks the current state of the bridge and changes its sprite accordingly
        if(state == 5){
            setImage("bridge.png");
        }        
        else if(state == 0){
            setImage("bridge_destroyed_1.png");
        }
        else if(state == 1){
            setImage("bridge_destroyed_2.png");
        }
        else if(state == 2){
            setImage("bridge_destroyed_3.png");
        }        
        else if(state == 3){
            setImage("bridge_destroyed_4.png");
        }        
        else if(state == 4){
            setImage("bridge_destroyed_5.png");
        }
    }
}
