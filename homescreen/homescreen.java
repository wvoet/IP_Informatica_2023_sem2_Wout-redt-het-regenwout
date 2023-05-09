import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Homescreen extends World
{
    public Player player;
    private int counter;
    public GreenfootImage counterImage;
    /**
     * Constructor for objects of class homescreen.
     * 
     */
    public Homescreen ()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(2048, 2048, 1); 
        prepare();
        counter = 0;
        counterImage = new GreenfootImage(100,50);
        updateCounterImage();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cleanwater cleanwater = new Cleanwater();
        addObject(cleanwater,1782,380);
        Lifeonland lifeonland = new Lifeonland();
        addObject(lifeonland,324,330);
        Peace peace = new Peace();
        addObject(peace,337,1858);
        Player player = new Player();
        addObject(player,250,300);

    }

    public void increaseCounter() {
        counter++;
        updateCounterImage();
    }

    public void decreaseCounter() {
        counter--;
        updateCounterImage();
    }

    private void updateCounterImage() {
       counterImage.clear();
       counterImage.drawString("Aantal zaden:" + counter, 10, 25);
       
       getBackground().drawImage(counterImage, 50, 25);
        
    }
}
