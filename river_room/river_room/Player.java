import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public int xplayer;
    public int yplayer;
    public Boolean cutsceneMode = false;
    public int playerLives = 3;
    public int planksCollected = 0;
    public int garbageCollected = 0;
    public int bridge1;

    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        isInRiver();
        damage();
        collectPlank();
        collectGarbage();
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
    
    public void isInRiver(){
        //confines player to river
        if(cutsceneMode == false){
            if(isTouching(River.class)){
                if (getX()<200) setLocation(200, getY());
                if (getX()>600) setLocation(600, getY());
            }
        }  
    }
    
    public void damage(){
        //keeps track of damage done by hazards, resets level when levels reach zero
        if(isTouching(toxicWaste.class)){
            playerLives = playerLives - 1;
            removeTouching(toxicWaste.class);
        }
        if(isTouching(log.class)){
            playerLives = playerLives - 1;
            removeTouching(log.class);
        }
        if(playerLives < 1){
            getWorld().showText("Game Over", 405, 320);
            Greenfoot.delay(3000);
            Greenfoot.setWorld(new RivierKamer());
        }
        String lives = "Lives: " + playerLives;
        getWorld().showText(lives, 600, 61);
    }
    
    public void collectPlank(){
        //logic for collecting planks and adjusting bridge sprite and completing the level
        if(isTouching(plank.class)){
            planksCollected = planksCollected + 1;
            removeTouching(plank.class);
            String planks = "Planks collected: " + planksCollected + "/10";
            getWorld().showText(planks, 640, 80);

        }   
        int newState = planksCollected / 2;
        for (Object obj : getWorld().getObjects(bridge.class))
        {
            bridge bridge = (bridge) obj;
            bridge.bridgeState(newState);
        }
        if(planksCollected == 10){
            ((RivierKamer)getWorld()).CutsceneEnd();
        }
    }

    public void collectGarbage(){
        //logic for collecting garbage and changing the scene when ammount reaches 10
        if(isTouching(garbage.class)){
            garbageCollected = garbageCollected + 1;
            removeTouching(garbage.class);
            String garbage = "Garbage collected: " + garbageCollected + "/10";
            getWorld().showText(garbage, 640, 80);
        }
        if(garbageCollected == 10){
            playerLives = 3;
            ((RivierKamer)getWorld()).SceneChange();
            garbageCollected = 0;
        }
    }
}    

