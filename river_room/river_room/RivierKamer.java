import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dit level speelt zich af in een vervuilde rivier. De speler valt in het water nadat
 * de brug het begeeft. Het level is opgebouwd uit 2 fases. In de eerste fase is het de
 * bedoeling om de rivier op te ruimen terwijl de speler toxisch afval en krokodillen
 * moet vermijden. In de tweede fase komt de omgevende natuur opniuew tot leven en moet met hout verzamelen
 * om de brug te herbouwen terwijl hij boomstammen en krokodillen ontwijkt.
 * 
 * @author Arno De Pauw
 * @version V1
 */
public class RivierKamer extends World
{
    public static final int RESOLUTION = 1;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public River river1;
    public bridge bridge1;
    public Player player;
    public Boolean Phase1Active;
    public int playerLives;

    private GreenfootImage map;

    private Timer spawnTimer;

    /**
     * Creates the room
     */
    public RivierKamer()
    //keep track of #garbage & # planks collected and performs scene stages
    {    
        super(WIDTH / RESOLUTION, HEIGHT / RESOLUTION, RESOLUTION);
        map = new GreenfootImage("background_phase_1.png");
        map.scale(getWidth(), getHeight());
        setBackground(map);
        setPaintOrder(bridge.class, Player.class, log.class, toxicWaste.class,
            garbage.class, plank.class, River.class);
        //spawns player, river etc.
        initRivierKamer();
        //timer used for spawning objects in the river at random timeinterval (2-4)
        spawnTimer = new Timer((Greenfoot.getRandomNumber(2) + 2) * 1000, new ActionListener() 
        {
            public void actionPerformed(ActionEvent e){
                spawnCollectable();
                spawnTimer.setDelay((Greenfoot.getRandomNumber(2) + 2) * 1000);
            }
        });
        //starts phase 1
        CutsceneStart();
    }

    public void initRivierKamer()
    //spawns player, bridge and river
    {
        bridge1 = new bridge();
        addObject(bridge1, 405, 320);
        river1 = new River();
        addObject(river1, 400, 61);
        player = new Player();
        addObject(player, 405, 320);
    }

    public void CutsceneStart()
    //starts phase 1; bridge is broken, objects start to spawn
    {
        Phase1Active = true;
        bridge1.bridgeState(0);
        spawnTimer.start();
    }

    public void SceneChange()
    //switches background, removes trash, changes river sprite, starts spawning logs & planks
    {
        Phase1Active = false;
        removeObjects(getObjects(garbage.class));
        removeObjects(getObjects(toxicWaste.class));
        map = new GreenfootImage("background_phase_2.png");
        map.scale(getWidth(), getHeight());
        setBackground(map);
        GreenfootImage riverClean = new GreenfootImage("river_clean.png");
        river1.setImage(riverClean);
    }

    public void CutsceneEnd()
    //despawns everything except player & bridge, level ends
    {
        spawnTimer.stop();
        removeObjects(getObjects(plank.class));
        removeObjects(getObjects(log.class));
        showText("level complete", 405, 320);
        Greenfoot.delay(3000);
        //Greenfoot.setWorld(new Fabriek());
    }

    public void spawnCollectable()  //spawns either a hazard or a collectible with random appearance at a random location
    {
        int placeRandomizer = Greenfoot.getRandomNumber(340) + 230 ;
        int hazardRandomizer = Greenfoot.getRandomNumber(4);
        int seedRandomizer = Greenfoot.getRandomNumber(15);
        if(Phase1Active == true){
            if(hazardRandomizer == 2){
                toxicWaste Hazard = new toxicWaste();
                addObject(Hazard, placeRandomizer, 1);
            }

            else{
                garbage randomGarbage = new garbage();
                randomGarbage.randomise();
                addObject(randomGarbage, placeRandomizer, 1);
            }
        }
        else if (Phase1Active == false){
            if(hazardRandomizer == 2){
                log Hazard = new log();
                addObject(Hazard, placeRandomizer, 1);
            }
            //else if(seedRandomizer == 7){
                //seed zaadje= new seed();
                //addObject(zaadje, placerandomizer, 1);
            //}
            else{
                plank randomPlank = new plank();
                randomPlank.randomise();
                addObject(randomPlank, placeRandomizer, 1);
            }
        }
    }
}

