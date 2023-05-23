import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Doos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doos extends Actor
{   private int speed = 2; 
    private boolean isBeingHeld = false;
    public void act() {      
        if (!isBeingHeld) {
            move(speed);
            checkEdge();
        }
    }

    private void checkEdge() {
        if (isAtEdge()) {
            setLocation(0, 514);
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

    public Doos() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 5, image.getHeight() / 5);
        setImage(image);
    }

}

