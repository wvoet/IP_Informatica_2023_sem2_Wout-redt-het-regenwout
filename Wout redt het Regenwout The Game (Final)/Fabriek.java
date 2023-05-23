import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fabriek here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fabriek extends WoutRedtHetRegenwoud
{
    private GreenfootImage map;

    private Key key;
    private KeyDia keyDia;
    private KeyDiaR keyDiaR;

    private Hydrant hydrant;
    private HydrantDia hydrantDia;
    private HydrantDiaR hydrantDiaR;

    public Player player;
    public int timer = 500;

    public Fabriek() {    
        map = new GreenfootImage("achtergrond fabriek.png");
        map.scale(getWidth(), getHeight());
        setBackground(map);
        setPaintOrder(Doos.class,DoosDia.class, DoosDiaR.class, Key.class, KeyDia.class, KeyDiaR.class,
        Player.class,Hydrant.class, HydrantDia.class, HydrantDiaR.class, Seed.class);
        initFabriek();
    }

    public void act() {
        checkPlacement();
        instructions();
    }

    public void initFabriek()
    //spawns player, bridge and river
    {
        player = new Player();
        addObject(player, 403, 301);
        
        Greenfoot.delay(300);
        Doos doos = new Doos();
        addObject(doos,763,514);
        Doos doos2 = new Doos();
        addObject(doos2, 619,514);
        Doos doos3 = new Doos();
        addObject(doos3,387,514);
        Doos doos4 = new Doos();
        addObject(doos4,236,514);
        Doos doos5 = new Doos();
        addObject(doos5,69,514);
        Doos doos6 = new Doos();
        addObject(doos6,495,514); 

        DoosDiaR doosDiaR = new DoosDiaR();
        addObject(doosDiaR,743,170);
        DoosDiaR doosDiaR2 = new DoosDiaR();
        addObject(doosDiaR2,692,113);
        DoosDiaR doosDiaR3 = new DoosDiaR();
        addObject(doosDiaR3,580,24);

        Key key = new Key();  //key
        addObject(key,387,514);
        KeyDia keyDia = new KeyDia();  //keydia
        addObject(keyDia,39,204);
        KeyDiaR keyDiaR = new KeyDiaR();    //keydiar
        addObject(keyDiaR,580,24);
        
        Seed seed = new Seed();
        addObject(seed,619,514);
        Seed seed2 = new Seed();
        addObject(seed2,495,514);
        
        DoosDia doosDia = new DoosDia();
        addObject(doosDia,39,204);
        DoosDia doosDia2 = new DoosDia();
        addObject(doosDia2,96,128);
        DoosDia doosDia3 = new DoosDia();
        addObject(doosDia3,193,34);

        Hydrant hydrant = new Hydrant();   //hydrant
        addObject(hydrant,111,410);
        HydrantDia hydrantDia = new HydrantDia();    //hydrantdia
        addObject(hydrantDia,314,138);
        HydrantDiaR hydrantDiaR = new HydrantDiaR();    //hydrantdiar
        addObject(hydrantDiaR,696,365);
    }

    private void checkPlacement() {
        Key key = (Key) getObjects(Key.class).get(0);
        int keyX = key.getX();
        int keyY = key.getY();
        KeyDia keyDia = (KeyDia) getObjects(KeyDia.class).get(0);
        int keyDiaX = keyDia.getX();
        int keyDiaY = keyDia.getY();
        KeyDiaR keyDiaR = (KeyDiaR) getObjects(KeyDiaR.class).get(0);
        int keyDiaRX = keyDiaR.getX();
        int keyDiaRY = keyDiaR.getY();

        Hydrant hydrant = (Hydrant) getObjects(Hydrant.class).get(0);
        int hydrantX = hydrant.getX();
        int hydrantY = hydrant.getY();
        HydrantDia hydrantDia = (HydrantDia) getObjects(HydrantDia.class).get(0);
        int hydrantDiaX = hydrantDia.getX();
        int hydrantDiaY = hydrantDia.getY();
        HydrantDiaR hydrantDiaR = (HydrantDiaR) getObjects(HydrantDiaR.class).get(0);
        int hydrantDiaRX = hydrantDiaR.getX();
        int hydrantDiaRY = hydrantDiaR.getY();

        if (Math.abs(keyX - hydrantX) <= 15 && Math.abs(keyY - hydrantY) <= 15 &&
        Math.abs(keyDiaX - hydrantDiaX) <= 15 && Math.abs(keyDiaY - hydrantDiaY) <= 15 &&
        Math.abs(keyDiaRX - hydrantDiaRX) <= 15 && Math.abs(keyDiaRY - hydrantDiaRY) <= 15) {
            showText("Klaar! Je hebt het regenwoud gered!", getWidth() / 2, getHeight() / 2);
            Greenfoot.delay(300);
            Greenfoot.setWorld(new Homescreen()); 
        }
    }
    
    public void instructions()
    {
        if(timer > 250){
            showText("match the correct key to each valve", 403, 401);
            timer --;
        }
        else if(timer > 0){
            showText("you can look under the boxes by clicking on them. click again to drop them", 403, 401);
            timer --;
        }
        else{
            showText("", 403, 401);
        }
    }
    
}
