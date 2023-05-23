import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyDiaR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyDiaR extends Actor
{
    private int speed = 2; 
    private boolean isBeingHeld = false;
    public void act() {
        setRotation(48);
        move(speed);
        checkEdge();
    }

    public void checkEdge() {
        if (isAtEdge()) {
            setLocation(551, 10);
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

    public KeyDiaR() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 10, image.getHeight() / 10);
        setImage(image); 
    }
}
