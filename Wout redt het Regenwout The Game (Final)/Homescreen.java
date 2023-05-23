import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // imports arrays for tree coordinates (GPT)
import java.awt.Point; //imports lib for keeping track of locations (GPT)
import java.util.List;
/**
 * Write a description of class homescreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Homescreen extends WoutRedtHetRegenwoud
{
    public Player player;
    public boolean SDGsread = false;    
    private GreenfootImage map;

    static int seedCount;

    public void act(){
        text();
        SDGsRead();
    }

    /**
     * Constructor for objects of class homescreen.
     * 
     */
    public Homescreen ()
    {    
        map = new GreenfootImage("homescreen_background.jpg");
        map.scale(getWidth(), getHeight());
        setBackground(map);

        prepare();
        spawnTrees();
        SDGsRead();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Cleanwater cleanwater = new Cleanwater();
        addObject(cleanwater,665,159);
        Lifeonland lifeonland = new Lifeonland();
        addObject(lifeonland,127,126);
        Peace peace = new Peace();
        addObject(peace,205,508);
        Player player = new Player();
        addObject(player,400,250);
        player.setWorld(this);
    }

    public void SDGsRead()
    //checks if the player has read all DSGs before encouraging them to move on
    {
        if (((Player)getObjects(Player.class).get(0)).lifeonlandRead && ((Player)getObjects(Player.class).get(0)).cleanwaterRead && ((Player)getObjects(Player.class).get(0)).peaceRead){
            SDGsread = true;
        }
    }

    public void text()
    {
        //decides which text should be displayed at what time
        int cleanwaterobjects = getObjects(Cleanwater_explanation.class).size();
        int peaceobjects = getObjects(Peace_explanation.class).size();
        int lifeonlandobjects = getObjects(Lifeonland_explanation.class).size();
        if(cleanwaterobjects != 0){}
        else if(peaceobjects != 0) {}
        else if(lifeonlandobjects != 0) {}
        else{
            if(SDGsread){
                showText("Press SPACE when you're ready to begin", 405, 390);
            }
            else{
                if (seedCount > 0){
                    showText("plant your seeds by pressing P", 405, 390);
                }
                else{
                    showText("Take a look at the different SDGs by walking into them.", 405, 390);
                }
            }
        }
    }

    private void spawnTrees() {
        WoutRedtHetRegenwoud world = this;
        List<Point> treeCoordinates = world.getTreeCoordinates();

        // Add trees based on the stored coordinates
        for (Point coordinate : treeCoordinates) {
            int x = (int) coordinate.getX();
            int y = (int) coordinate.getY();
            Boom tree = new Boom();
            addObject(tree, x, y);
        }
    }

    static void setSeedCount(int count) {
        seedCount = count;
    }
}
