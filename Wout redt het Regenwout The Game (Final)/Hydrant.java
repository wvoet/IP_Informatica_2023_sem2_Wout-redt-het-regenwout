import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hydrant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hydrant extends Actor
{  
    public Hydrant() {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() / 4, image.getHeight() / 4);
        setImage(image);
    }
}
