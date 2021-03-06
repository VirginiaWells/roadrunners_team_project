import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int spawnTimer = 0;
    int houseTimer = 0;
    private int obstacleCounter = 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 1000x900 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1, false); 
        GreenfootImage bg = new GreenfootImage("backgroundTemp.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        addObject (new Line(), 300, 20);
        addObject (new Line(), 300, 100);
        addObject (new Line(), 300, 300);
        addObject (new Line(), 300, 500);
        addObject (new Line(), 300, 700);
        addObject (new Line(), 300, 900);
        addObject (new Line(), 700, 100);
        addObject (new Line(), 300, 200);
        addObject (new Line(), 300, 400);
        addObject (new Line(), 300, 600);
        addObject (new Line(), 300, 800);
        addObject (new Line(), 300, 1000);
        addObject (new Line(), 700, 20);
        addObject (new Line(), 700, 100);
        addObject (new Line(), 700, 300);
        addObject (new Line(), 700, 500);
        addObject (new Line(), 700, 700);
        addObject (new Line(), 700, 900);
        addObject (new Line(), 700, 200);
        addObject (new Line(), 700, 400);
        addObject (new Line(), 700, 600);
        addObject (new Line(), 700, 800);
        addObject (new Line(), 700, 1000);
        addObject (new Car(), 600, 500);
        addObject (new longLine(), 495, 700);
        addObject (new longLine(), 505, 700);
        addObject (new longLine(), 495, 200);
        addObject (new longLine(), 505, 200);
        setPaintOrder(Explosion.class, Car.class, Missile.class, Bomb.class, fireworks.class, finishLine.class, Cone.class, Obstacle.class, Gas.class, Puddle.class, Line.class, longLine.class, House.class, Tree.class);
    }
    public void act() {
        spawnTimer++;
        houseTimer++;
        GreenfootSound music = new GreenfootSound("runningCar.mp3");
        if(!music.isPlaying()) {
                music.play();
                music.setVolume(5);
        }
        
        if (spawnTimer == 15) {
            addObject (new Tree(), Greenfoot.getRandomNumber(120), 0);
            addObject (new Tree(), Greenfoot.getRandomNumber(100) + 900, 0); 
            spawnTimer = 0;
        }
        if (spawnTimer == 14) {
            addObject (new Line(), 300, 0);
            addObject (new Line(), 700, 0);
        }
        if (houseTimer == 40) {
            addObject (new House(), Greenfoot.getRandomNumber(100), 0);
            addObject (new House(), Greenfoot.getRandomNumber(90) + 910, 0);
            houseTimer = 0;
        }
        if (Greenfoot.getRandomNumber(200) == 100) {
            addObject (new Obstacle(), Greenfoot.getRandomNumber(600) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(200) == 20) {
            addObject (new Cone(), Greenfoot.getRandomNumber(600) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(200) == 50) {
            addObject (new Puddle(), Greenfoot.getRandomNumber(600) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(500) == 1) {
            addObject (new Gas(), Greenfoot.getRandomNumber(600) + 200, 0);
        }
    }
    
    public void spawnObjects() {
        int minX = Greenfoot.getRandomNumber(660) + 180;
        
        switch (obstacleCounter) {
            case 150:
                int rand = Greenfoot.getRandomNumber(4) + 1;
                obstacleCounter += rand;
                break;
                
            case 151:
                //barrier,barrier,barrier
                if(minX <= 500) {
                    addObject(new Obstacle(), minX, -20);
                    addObject(new Obstacle(), minX + 120, -20);
                    addObject(new Obstacle(), minX + 240, -20);
                }
                else {
                    addObject(new Obstacle(), minX, -20);
                    addObject(new Obstacle(), minX - 120, -20);
                    addObject(new Obstacle(), minX - 240, -20);
                }
                obstacleCounter = 0;
                break;
                
            case 152:
                //barrier,gas,barrier
                addObject(new Obstacle(), minX, -20);
                addObject(new Gas(), minX + 130, -20);
                addObject(new Obstacle(), minX + 240, -20);
                obstacleCounter = 0;
                break;
                
            case 153:
                //puddle,cone,gap,barrier,cone
                addObject(new Puddle(), 210, -20);
                addObject(new Cone(), 290, -20);
                addObject(new Obstacle(), 810, -20);
                addObject(new Cone(), 700, -20);
                obstacleCounter = 0;
                break;
                
            case 154:
                //cone,puddle,cone,barrier,puddle
                addObject(new Cone(), 230, -20);
                addObject(new Puddle(), 310, -20);
                addObject(new Cone(), 390, -20);
                addObject(new Obstacle(), 810, -20);
                addObject(new Puddle(), 680, -20);
                obstacleCounter = 0;
                break;    
                
            default:
                obstacleCounter++;
        }
    }
}
