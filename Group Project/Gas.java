import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gas extends Actor
{
    /**
     * Act - do whatever the Gas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() + 5);
        outBounds();
    }
    
    public void outBounds() {
        if (getY() > 920 || getX() < 180 || getX() > 840) {
            getWorld().removeObject(this);
        }
    }    
}
