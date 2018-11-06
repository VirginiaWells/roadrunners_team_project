import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Actor
{
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveUp();
        impact();
        
    }
    
    public void moveUp() {
        setLocation(getX(), getY() - 10);
    }
    
    public void impact() {
        if (isTouching(Obstacle.class) || isTouching(Cone.class) || isTouching(Gas.class)) {
            List<Obstacle> blownObstacle = getObjectsInRange(200, Obstacle.class);
            List<Cone> blownCone = getObjectsInRange(100, Cone.class);
            getWorld().addObject(new Explosion(), getX(), getY());
 
            for (Obstacle barrier : blownObstacle) {
                getWorld().removeObject(barrier);
            }
            for (Cone cone : blownCone) {
                getWorld().removeObject(cone);
            }
            getWorld().removeObject(this);
        }
    }
}
