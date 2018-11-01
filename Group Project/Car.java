import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    int obstaclesHit = 0;
    int puddleCounter = 10;
    int gasMeter = 0;
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        puddleCounter++;
        splishSplash();
        if (Greenfoot.isKeyDown("left")) {
            move(-10);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(10);
        }
        if (getX() <= 180) {
            setLocation(getX() + 20, getY());
        }
        if (getX() >= 840) {
            setLocation(getX() - 20, getY());
        }
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
            if (gasMeter >= 20) {
                Greenfoot.stop();
            }
        }
    }    
    public void splishSplash() {
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
}
