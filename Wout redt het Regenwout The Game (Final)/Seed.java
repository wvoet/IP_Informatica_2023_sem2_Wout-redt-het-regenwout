import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zaad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seed extends Actor
{
    private GreenfootImage counterImage;
    boolean isBeingHeld = false;
    /**
     * Act - do whatever the Zaad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        inRiver();
        if (!isBeingHeld && getWorld() instanceof Fabriek) {
            move(2);
            checkEdge();
        }
    }

    public void inRiver()
    {
        //makes the seed drift downstream if its in the river
        if(getWorld() instanceof RivierKamer) {
            setLocation(getX(), getY() + 1);
            if (isAtEdge()){
                getWorld().removeObject(this);
            }   
        }
    }

    public void checkEdge() {
        if (isAtEdge()) {
            setLocation(0, 514);
        }
    }

    public void setIsBeingHeld(boolean held) 
    {   isBeingHeld = held;
        if (isBeingHeld) {
            move(0);
        } 
        else {
            move(0);
        }
    }

}
