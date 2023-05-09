import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zaad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seed extends Actor
{
    private int counter;
    private GreenfootImage counterImage;
    /**
     * Act - do whatever the Zaad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        delete();

    }
    public void delete(){
        if (isTouching(Player.class)){
            getWorld().removeObject(this);
        }
    }

    

}
