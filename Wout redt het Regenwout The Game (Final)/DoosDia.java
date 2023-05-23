import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoosDia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoosDia extends Actor
{   private int speed = 2; 
    private boolean isBeingHeld = false;
    public void act() {      
        setRotation(-49);
        move(speed);
        checkEdge();

        if (isAtEdge()) {
            setLocation(1, 290);
        }
    }

    private void checkEdge() {
    }

    public void setIsBeingHeld(boolean held) 
    {   isBeingHeld = held;
        if (isBeingHeld) {
            speed = 0;
        } else {
            speed = 0;
        }
    }

    public DoosDia() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 5, image.getHeight() / 5);
        setImage(image);
    }
}

