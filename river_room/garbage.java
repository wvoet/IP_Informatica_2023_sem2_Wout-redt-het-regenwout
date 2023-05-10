import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class garbage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class garbage extends Actor
{
    GreenfootImage type1 = new GreenfootImage("trashbag.png");
    GreenfootImage type2 = new GreenfootImage("plastic_bag.png");
    GreenfootImage type3 = new GreenfootImage("rusty_can.png");
    GreenfootImage type4 = new GreenfootImage("old_tire.png");
    GreenfootImage type5 = new GreenfootImage("broken_bottle.png");
    GreenfootImage type6 = new GreenfootImage("beverage_can.png");
    GreenfootImage type7 = new GreenfootImage("oil_barrel.png");
    
    /**
     * Act - do whatever the garbage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // needs to randomly generate a piece of trash, let it flow along with the river,
        // and remove it again after it leaves the screen. used in stage 1
        inRiver();
        
        
    }
    public void randomise()
    {
        int randomizer = Greenfoot.getRandomNumber(7); 
        if(randomizer == 1){
            setImage(type1);
        }
        if(randomizer == 2){
            setImage(type2);
        }
        if(randomizer == 3){
            setImage(type3);
        }
        if(randomizer == 4){
            setImage(type4);
        }
        if(randomizer == 5){
            setImage(type5);
        }
        if(randomizer == 6){
            setImage(type6);
        }
        if(randomizer == 7){
            setImage(type7);
        }
    }
    public void inRiver()
    {
        setLocation(getX(), getY() + 1);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }        
    }
}
