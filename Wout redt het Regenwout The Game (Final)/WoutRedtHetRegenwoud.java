import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // imports arrays for tree coordinates (GPT)
import java.awt.Point; //imports lib for keeping track of locations (GPT)
import java.util.List;
/**
 * Write a description of class WoutRedtHetRegenwoud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WoutRedtHetRegenwoud extends World
{
    public static final int RESOLUTION = 1;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public int zaadjes;
    private List<Point> treeCoordinates;
    /**
     * Constructor for objects of class WoutRedtHetRegenwoud.
     * 
     */
    public WoutRedtHetRegenwoud()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(WIDTH / RESOLUTION, HEIGHT / RESOLUTION, RESOLUTION);
        treeCoordinates = new ArrayList<>();
        Player player = new Player();
        player.setWorld(this);
    }

    public void increase() {
        zaadjes++;
        updatePlayerSeedCount();
    }

    public void decrease() {
        if (zaadjes > 0) {
            zaadjes--;
            updatePlayerSeedCount();
        }
    }

    private void updatePlayerSeedCount() {
        Homescreen.setSeedCount(zaadjes);
    }

    public void restartGame() {
        Greenfoot.setWorld(new WoutRedtHetRegenwoud());
        Greenfoot.setWorld(new Homescreen());
    }

    public void addTreeCoordinate(int x, int y) {
        treeCoordinates.add(new Point(x, y));
    }

    public List<Point> getTreeCoordinates() 
    {
        return treeCoordinates;
    }

    public void setTreeCoordinates(List<Point> coordinates) {
        treeCoordinates = coordinates;
    }
}
