import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    private static final int LEFT_BOUNDARY = 180;
    private static final int RIGHT_BOUNDARY = 840;
    
    private int obstaclesHit = 0;
    GreenfootImage dented = new GreenfootImage("whitecardam.png");
    GreenfootImage damaged = new GreenfootImage("whitecarsevdam.png");
    GreenfootImage explode = new GreenfootImage("bombmybombnewbombtimesten.png");
    private int puddleCounter = 10;
    private static int bombReloadTime = 100;
    private int bombReload = 0;
    private int gasMeter = 0;
    private int explosionCounter = 0;

    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        puddleCounter++;
        //hitPuddle();
        carMove();
        hitBoundary();
        carDamage();
        dropBomb();
        
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        if (obstacle != null) {
            getWorld().removeObject(obstacle);
            obstaclesHit++;
            Greenfoot.playSound("hittingCone.mp3");

            if (obstaclesHit >= 10) {
                Greenfoot.stop();
            }
        }
        Actor cone = getOneIntersectingObject(Cone.class);
        if (cone != null) {
            getWorld().removeObject(cone);
            obstaclesHit++;
            Greenfoot.playSound("hittingCone.mp3");
            if (obstaclesHit >= 10) {
                Greenfoot.stop();
            }
        }
        if (puddleCounter > 15) {
            Actor puddle = getOneIntersectingObject(Puddle.class);
            if (puddle != null) {
                puddleCounter = 0;
                Greenfoot.playSound("puddle.mp3");
            }
        }
        Actor gas = getOneIntersectingObject(Gas.class);
        if (gas != null) {
            getWorld().removeObject(gas);
            gasMeter++;
            if (gasMeter == 1) { //changed to 1 for testing
                getWorld().addObject (new finishLine(), 508, 0);
            }
        }

        
        Actor finish = getOneIntersectingObject(finishLine.class);
        if (/*finish != null*/false) {
            getWorld().addObject (new fireworks(), 400, 700);
            getWorld().addObject (new fireworks(), 800, 800);
            getWorld().addObject (new fireworks(), 900, 850);
            getWorld().addObject (new fireworks(), 300, 775);
            getWorld().addObject (new fireworks(), 200, 800);
            getWorld().addObject (new fireworks(), 100, 700);
            getWorld().addObject (new fireworks(), 200, 750);
            Greenfoot.playSound("finish.mp3");
            Greenfoot.stop();
        }

    }    
    public void hitPuddle() {
        if (puddleCounter == 0) {
            move(-15);
        }
        if (puddleCounter == 1) {
            setLocation(getX(), getY() + 15);
            turn(-15);
        }
        if (puddleCounter == 2) {
            move(15);
        }
        if (puddleCounter == 3) {
            setLocation(getX(), getY() - 15);
            turn(30);
        }
        if (puddleCounter == 4) {
            move(-15);
        }
        if (puddleCounter == 5) {
            setLocation(getX(), getY() + 15);
            turn(-30);
        }
        if (puddleCounter == 6) {
            move(15);
        }
        if (puddleCounter == 7) {
            setLocation(getX(), getY() - 15);
            turn(15);
        }
        if (puddleCounter == 8) {
            setLocation(getX(), 700);
        }
    }
    
    public void carMove() {
        if (Greenfoot.isKeyDown("left")) {
            move(-10);
        }
        
        if (Greenfoot.isKeyDown("right")) {
            move(10);
        }
    }
    
    public void hitBoundary() {
        if (getX() <= LEFT_BOUNDARY) {
            setLocation(getX() + 20, getY());
        }
        
        if (getX() >= RIGHT_BOUNDARY) {
            setLocation(getX() - 20, getY());
        }
    }
    
    public void carDamage() {
        
        switch (obstaclesHit) {
            
            case 1:
                //setImage("whitecardam.png");
                break;
                
            case 2:
                //setImage("whitecardam.png");
                break;
                
            case 3:
                //setImage("whitecardam.png");
                break;
                
            case 4:
                //setImage("whitecardam.png");
                break;
                
            case 5:
                if (explosionCounter <= 35) {
                    getWorld().addObject(new Explosion(), getX(), getY());    
                    explosionCounter++;
                }
                else if (explosionCounter > 35 && explosionCounter <= 50) {
                    explosionCounter++;
                }
                else if (explosionCounter > 50 && explosionCounter <= 75) {
                    getWorld().addObject(new Explosion(), getX(), getY());    
                    explosionCounter++;    
                }
                break;    
            
        }
    }
    
    public void dropBomb() {
        
        if (bombReload <= bombReloadTime) {
            bombReload = bombReload + 1;
        }
        
        if (Greenfoot.isKeyDown("shift") && bombReload > bombReloadTime) {
            getWorld().addObject(new Bomb(), getX(), (getY() + 80));
            bombReload = 0;
        }
    }
}
