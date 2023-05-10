import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class plank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class plank extends Actor
{
    GreenfootImage type1 = new GreenfootImage("plank1.png");
    GreenfootImage type2 = new GreenfootImage("plank2.png");
    GreenfootImage type3 = new GreenfootImage("plank3.png");
    GreenfootImage type4 = new GreenfootImage("plank4.png");
    GreenfootImage type5 = new GreenfootImage("plank5.png");
    GreenfootImage type6 = new GreenfootImage("plank6.png");
    GreenfootImage type7 = new GreenfootImage("plank7.png");
    GreenfootImage type8 = new GreenfootImage("plank8.png");
    GreenfootImage type9 = new GreenfootImage("plank9.png");
    GreenfootImage type10 = new GreenfootImage("plank10.png");
    GreenfootImage type11 = new GreenfootImage("plank11.png");
    /**
     * same mechanics as garbage but for stage 2
     */
    public void act()
    {
        inRiver();

    }
    public void randomise()
    {
        int randomizer = Greenfoot.getRandomNumber(11); 
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
        if(randomizer == 8){
            setImage(type8);
        }
        if(randomizer == 9){
            setImage(type9);
        }
        if(randomizer == 10){
            setImage(type10);
        }  
        if(randomizer == 11){
            setImage(type11);
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
