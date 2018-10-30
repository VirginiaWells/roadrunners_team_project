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
    int obstacleTimer = 0;
    int coneTimer = 0;
    int puddleTimer = 0;
    int gasTimer = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1, false); 
        GreenfootImage bg = new GreenfootImage("backgroundTemp.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        Car car1 = new Car();
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        Line line4 = new Line();
        Line line5 = new Line();
        Line line7 = new Line();
        Line line8 = new Line();
        Line line9 = new Line();
        Line line10 = new Line();
        Line line11 = new Line();
        Line line12 = new Line();
        Line line13 = new Line();
        Line line51 = new Line();
        Line line52 = new Line();
        Line line53 = new Line();
        Line line54 = new Line();
        Line line55 = new Line();
        Line line58 = new Line();
        Line line59 = new Line();
        Line line510 = new Line();
        Line line511 = new Line();
        Line line512 = new Line();
        Line line513 = new Line();
        addObject (line13, 300, 20);
        addObject (line1, 300, 100);
        addObject (line2, 300, 300);
        addObject (line3, 300, 500);
        addObject (line4, 300, 700);
        addObject (line5, 300, 900);
        addObject (line7, 700, 100);
        addObject (line8, 300, 200);
        addObject (line9, 300, 400);
        addObject (line10, 300, 600);
        addObject (line11, 300, 800);
        addObject (line12, 300, 1000);
        Line line751 = new Line();
        Line line752 = new Line();
        Line line753 = new Line();
        Line line754 = new Line();
        Line line755 = new Line();
        Line line758 = new Line();
        Line line759 = new Line();
        Line line7510 = new Line();
        Line line7511 = new Line();
        Line line7512 = new Line();
        Line line7513 = new Line();
        addObject (line7513, 700, 20);
        addObject (line751, 700, 100);
        addObject (line752, 700, 300);
        addObject (line753, 700, 500);
        addObject (line754, 700, 700);
        addObject (line755, 700, 900);
        addObject (line758, 700, 200);
        addObject (line759, 700, 400);
        addObject (line7510, 700, 600);
        addObject (line7511, 700, 800);
        addObject (line7512, 700, 1000);
        addObject (car1, 600, 700);
        longLine middleLane = new longLine();
        longLine middleLane2 = new longLine();
        longLine middleLane3 = new longLine();
        longLine middleLane4 = new longLine();
        addObject (middleLane3, 495, 700);
        addObject (middleLane4, 505, 700);
        addObject (middleLane2, 495, 200);
        addObject (middleLane, 505, 200);
        setPaintOrder(Car.class, Bomb.class, Cone.class, Obstacle.class, Gas.class, Puddle.class, Line.class, longLine.class, House.class, Tree.class);
    }
    public void act() {
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        Line line1 = new Line();
        Line line2 = new Line();
        Line line3 = new Line();
        House house1 = new House();
        House house2 = new House();
        Obstacle obstacle1 = new Obstacle();
        Obstacle obstacle2 = new Obstacle();
        Obstacle obstacle3 = new Obstacle();
        Cone cone1 = new Cone();
        Cone cone2 = new Cone();
        Puddle puddle1 = new Puddle();
        Gas gas1 = new Gas();
        spawnTimer++;
        houseTimer++;
        obstacleTimer++;
        coneTimer++;
        puddleTimer++;
        gasTimer++;
        if (spawnTimer == 15) {
            addObject (tree1, Greenfoot.getRandomNumber(120), 0);
            addObject (tree2, Greenfoot.getRandomNumber(100) + 900, 0); 
            spawnTimer = 0;
        }
        if (spawnTimer == 14) {
            addObject (line1, 300, 0);
            addObject (line3, 700, 0);
        }
        if (houseTimer == 40) {
            addObject (house1, Greenfoot.getRandomNumber(100), 0);
            addObject (house2, Greenfoot.getRandomNumber(90) + 910, 0);
            houseTimer = 0;
        }
        if (obstacleTimer == 100) {
            addObject (obstacle1, Greenfoot.getRandomNumber(600) + 200, 0);
            obstacleTimer = 0;
        }
        if (Greenfoot.getRandomNumber(200) == 1) {
            addObject (cone2, Greenfoot.getRandomNumber(600) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(200) == 1) {
            addObject (puddle1, Greenfoot.getRandomNumber(600) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(200) == 1) {
            addObject (gas1, Greenfoot.getRandomNumber(600) + 200, 0);
        }
    }
}
