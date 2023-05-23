import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyDia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyDia extends Actor
{   private int speed = 2; 
    private boolean isBeingHeld = false;
    public void act() {
        setRotation(-49);
        move(speed);
        checkEdge();
    }

    public void checkEdge() {
        if (isAtEdge()) {
            setLocation(1, 290);
        }
    }

    public void setIsBeingHeld(boolean held) 
    {   isBeingHeld = held;
        if (isBeingHeld) {
            speed = 0;
        } else {
            speed = 0;
        }
    }

    public KeyDia() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 10, image.getHeight() / 10);
        setImage(image); 
    }
}
