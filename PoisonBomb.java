import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class PoisonBomb
 * rotates and moves the bomb to the top of the world 
 * once it hits the top the bomb is removed from the world
 * 
 * @author Belle Erhardt 
 * @version 3/21
 */
public class PoisonBomb extends Actor
{
    public PoisonBomb()
    {
    turn(90);
    }
    
    /**
     * Act - do whatever the PoisonBomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    move(-1);
    if (getY()==0)
    {getWorld().removeObject(this);}
    
    }    
}
