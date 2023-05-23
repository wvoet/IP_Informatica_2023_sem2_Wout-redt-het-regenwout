import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoosDiaR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoosDiaR extends Actor
{   private int speed = 2; 
    private boolean isBeingHeld = false;
    public void act() {      
        setRotation(48);
        move(speed);
        checkEdge();

        if (isAtEdge()) {
            setLocation(551, 10);
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

    public DoosDiaR() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 5, image.getHeight() / 5);
        setImage(image);
    }
}
