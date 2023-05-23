import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Player extends Actor
{
    public int xplayer;
    public int yplayer;
    public GreenfootImage noseed;
    public int playerLives = 3;
    public int planksCollected = 0;
    public int garbageCollected = 0;
    public int bridge1;
    public boolean lifeonlandRead = false;
    public boolean peaceRead = false;
    public boolean cleanwaterRead = false;
    public boolean holdingObject = false;
    public Actor object= null;
    private GreenfootImage originalImage;
    private int originalWidth, originalHeight;
    private WoutRedtHetRegenwoud world;

    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move();
        sdgs();
        plant();
        zaadjes();
        noseed = new GreenfootImage(100,50);
        isInRiver();
        damage();
        collectPlank();
        collectGarbage();
        startGame();
        carryObject();
        if (Greenfoot.isKeyDown("escape")) {
            WoutRedtHetRegenwoud world = (WoutRedtHetRegenwoud) getWorld();
            world.restartGame();
        }
    }

    public void move(){
        if(getWorld() instanceof Fabriek){
            if (Greenfoot.isKeyDown("z")) {
                setLocation(getX(), getY() - 5);
            }
            if (Greenfoot.isKeyDown("d")) {
                setLocation(getX() + 5, getY());
            }
            if (Greenfoot.isKeyDown("q")) {
                setLocation(getX() - 5, getY());
            }
            if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(), getY() + 5);
            }
        }
        else{
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
    }

    public void sdgs(){
        if ( isTouching(Peace.class))
        {
            getWorld().showText("Press X to close", 405, 390);
            peaceRead = true;
            getWorld().addObject(new Peace_explanation(),166,460);
            setLocation(getX() +5, getY() +5); 
            /** We brengen de player naar achter anders blijft hij het object van de peace sdg raken en wordt er onmiddelijk opniew de explanation 
            geopened. Dan moet de speler niet meer eerst ze'n mannetje verplaatsen.
             */
        }
        if ( isTouching(Lifeonland.class))
        {
            getWorld().showText("Press X to close", 405, 390);
            lifeonlandRead = true;
            getWorld().addObject(new Lifeonland_explanation(),127,126);
            setLocation(getX() +5, getY() +5);
        }
        if (isTouching(Cleanwater.class))
        {
            getWorld().showText("Press X to close", 405, 390);
            cleanwaterRead = true;
            getWorld().addObject(new Cleanwater_explanation(),665,159);
            setLocation(getX() + 5, getY() +5);
        }
    }

public void plant() {
    if (getWorld() instanceof Homescreen) {
        if (Greenfoot.isKeyDown("p")) {
            Greenfoot.delay(5);
            Homescreen world2 = (Homescreen) getWorld();
            if (world2.seedCount > 0) {
                world2.decrease(); // Decrease the seed count in the world
                Boom newBoom = new Boom();
                getWorld().addObject(newBoom, getX(), getY());
                ((Homescreen) world).addTreeCoordinate(getX(), getY());
            } else {
                noseed.drawString("You need to get more seeds to plant a tree.", 100, 50);
                Greenfoot.delay(50);
                noseed.clear();
            }
        }
    }
}

    public void zaadjes(){
        if (isTouching(Seed.class)&& !(getWorld() instanceof Fabriek)){
            // verwijder het zaadje en tel het op in de counter
            WoutRedtHetRegenwoud world = (WoutRedtHetRegenwoud) getWorld();
            world.increase(); // Increase the seed count in the world
            removeTouching(Seed.class);
        }
    }

    public void isInRiver()
    {
        //confines player to river
        if(isTouching(River.class)){
            if (getX()<200) setLocation(200, getY());
            if (getX()>600) setLocation(600, getY());
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
        if(playerLives < 1 && getWorld() instanceof RivierKamer){
            getWorld().showText("Game Over", 405, 320);
            Greenfoot.delay(100);
            Greenfoot.setWorld(new RivierKamer());
        }
        if (getWorld() instanceof RivierKamer){
            String lives = "Lives: " + playerLives;
            getWorld().showText(lives, 600, 61);
        }
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

    public void startGame(){
        if(getWorld() instanceof Homescreen){
            if (Greenfoot.isKeyDown("space")){
                Greenfoot.setWorld(new RivierKamer());
            }
        }
    }

    public void setImageToOriginal() {
        if (object != null && getWorld() instanceof Fabriek) {
            object.setImage(originalImage);
            if (object instanceof Doos) {
                ((Doos)object).setIsBeingHeld(false);
            }
        }  
    }

    public void carryObject()
    {
        if (getWorld() instanceof Fabriek)
        {
            if (holdingObject) {
                object.setLocation(getX(), getY());
                if (Greenfoot.mouseClicked(null)) {
                    WoutRedtHetRegenwoud world = (WoutRedtHetRegenwoud) getWorld();
                    int x = getX();
                    int y = getY();
                    setImageToOriginal();
                    if (object instanceof Seed) {
                        world.increase(); // Increase the seed count in the world
                        world.removeObject(object);
                    }  else {
                        world.addObject(object, x, y);
                    }
                    holdingObject = false;
                    object = null;
                }   else {
                    if (object instanceof Doos) {
                        ((Doos)object).setIsBeingHeld(true);
                    }
                    if (object instanceof Key) {
                        ((Key)object).setIsBeingHeld(true);
                    }
                    if (object instanceof DoosDia) {
                        ((DoosDia)object).setIsBeingHeld(true);
                    }
                    if (object instanceof DoosDiaR) {
                        ((DoosDiaR)object).setIsBeingHeld(true);
                    }
                    if (object instanceof KeyDia) {
                        ((KeyDia)object).setIsBeingHeld(true);
                    }
                    if (object instanceof KeyDiaR) {
                        ((KeyDiaR)object).setIsBeingHeld(true);
                    }
                }
            } 
            else {
                if (Greenfoot.mouseClicked(null)) {
                    object = getOneIntersectingObject(Actor.class);
                    if (object != null && !(object instanceof Hydrant || object instanceof HydrantDia || object instanceof HydrantDiaR)) {

                        originalImage = object.getImage();
                        originalWidth = originalImage.getWidth();
                        originalHeight = originalImage.getHeight();
                        GreenfootImage scaledImage = new GreenfootImage(originalImage);
                        scaledImage.scale(originalWidth / 2, originalHeight / 2);
                        object.setImage(scaledImage);
                        holdingObject = true;
                    }
                }
            }
        }
    }

    public void setWorld(WoutRedtHetRegenwoud world) {
        this.world = world;
    }
}
