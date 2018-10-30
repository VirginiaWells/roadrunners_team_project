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
    GreenfootImage dented = new GreenfootImage("whitecardam.png");
    GreenfootImage damaged = new GreenfootImage("whitecarsevdam.png");
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("left")) {
            move(-10);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(10);
        }
        if (getX() == 200) {
            setLocation(getX() + 10, getY());
        }
        if (getX() == 820) {
            setLocation(getX() - 10, getY());
        }
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        if (obstacle != null) {
            getWorld().removeObject(obstacle);
            obstaclesHit++;
            if (obstaclesHit == 3) {
                setImage(dented);
            }
            if (obstaclesHit == 7) {
                setImage(damaged);
            }
            if (obstaclesHit >= 10) {
                Greenfoot.stop();
            }
        }
    }    
}
