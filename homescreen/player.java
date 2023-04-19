import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        sdgs();
    }
    public void move(){
    if (Greenfoot.isKeyDown("up"))
    {
        setLocation(getX(), getY() - 5);
        setRotation(0);
    }
    if (Greenfoot.isKeyDown("down"))
    {
        setLocation(getX(), getY() +5);
        setRotation(180);
    }
    if (Greenfoot.isKeyDown("right"))
    {
        setLocation(getX()+5, getY());
        setRotation(90);
    }
    if (Greenfoot.isKeyDown("left"))
    {
        setLocation(getX()-5, getY());
        setRotation(270);
    }

}  
    public void sdgs(){
        if ( isTouching(peace.class) )
        {
<<<<<<< Updated upstream
            getWorld().addObject(new peace_explanation(),250,250);
            setLocation(getX(), getY() +5); /** We brengen de player naar achter anders blijft hij het object van de peace sdg raken en wordt er onmiddelijk opniew de explanation 
=======
            getWorld().addObject(new peace_explanation(),337,1858);
            setLocation(getX() +5, getY() +5); /** We brengen de player naar achter anders blijft hij het object van de peace sdg raken en wordt er onmiddelijk opniew de explanation 
>>>>>>> Stashed changes
            geopened. Dan moet de speler niet meer eerst ze'n mannetje verplaatsen.
            */
        }
        
        if ( isTouching(lifeonland.class))
        {
<<<<<<< Updated upstream
            getWorld().addObject(new lifeonland_explanation(),250,250);
            setLocation(getX(), getY() +5);
=======
            getWorld().addObject(new lifeonland_explanation(),324,330);
            setLocation(getX() +5, getY() +5);
>>>>>>> Stashed changes
        }
        
        if (isTouching(cleanwater.class))
        {
<<<<<<< Updated upstream
            getWorld().addObject(new cleanwater_explanation(),250,250);
            setLocation(getX(), getY() +5);
=======
            getWorld().addObject(new cleanwater_explanation(),1782,380);
            setLocation(getX() + 5, getY() +5);
>>>>>>> Stashed changes
        }
}
}