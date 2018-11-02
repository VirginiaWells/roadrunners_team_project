import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Explosion here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Explosion extends Actor
{
    private final double SCALE_FACTOR = 1.25;
    private final int MAX_SIZE = 8;
    private int size;
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = getImage();
        int width = (int) (img.getWidth() * SCALE_FACTOR);
        int height = (int) (img.getHeight() * SCALE_FACTOR);
        img.scale(width, height);
        size++;
        if (size == MAX_SIZE) {
            getWorld().removeObject(this);
        }
    }
    
    public Explosion() {
        GreenfootImage explosion = new GreenfootImage("explosion.png");
        size = 1;
        }
        
}
