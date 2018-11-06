import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class longLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class longLine extends Actor
{
    /**
     * Act - do whatever the longLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        outBounds();
    }
    
    public void outBounds() {
        if (getY() > 920) {
            getWorld().removeObject(this);
        }
    }
}
