import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Shelter class provides an object that can be "in the way"
 *   of Lobstrosities. 
 *
 * Although you are welcome to modify this class, IT IS **HIGHLY**
 * INADVISABLE THAT YOU MODIFY THIS CLASS.
 *
 * @author Stephen Blythe 
 * @version 1/2020
 */
public class Shelter extends Actor
{
    private int strengthLeft; // remaining strength
    
    // dimensions of the shelter object. Note that these are
    //   private as there is no reason to utiize these outside
    //   of this class. 
    private static final int SHELTER_WIDTH = 225;
    private static final int SHELTER_HEIGHT = 25;

    /**
     * Constructor for a shelter.
     * 
     * @param initialStrength is the starting strength of 
     *                        this shelter
     */
    public Shelter(int initialStrength)
    {
        strengthLeft = initialStrength; // remember initial strength
        redraw();   // redraw the shelter
    }
    
    // redraw simply rebuilds the image for the shelter. 
    //    note that methods outside this class should not call
    //    redraw, so it is private. 
    private void redraw()
    {
        // (re)build image if necessary
        GreenfootImage img = getImage();
        if (img==null || 
            img.getWidth()!=SHELTER_WIDTH ||
            img.getHeight()!=SHELTER_HEIGHT)
        {
            img = new GreenfootImage(SHELTER_WIDTH, SHELTER_HEIGHT);
            setImage(img);
        }
        
        // set background to light gray
        img.setColor(Color.LIGHT_GRAY);
        img.fill();
        
        // add text repressenting the strength left in black
        img.setColor(Color.BLACK);
        img.drawString(""+ strengthLeft, SHELTER_WIDTH/2-10, SHELTER_HEIGHT-8);
    }

    /**
     * reduceStrngth reduces this shelter's strength by 1 unit
     */
    public void reduceStrength()
    {
        reduceStrength(1); // use the other reduceStrength method
    }
    
    /**
     * reduceStrength reduces the strength of the shelter by a
     *           requested amount. 
     * @param byVal is the amount to reduce this shelter's strength
     */
    public void reduceStrength(int byVal)
    {        
        strengthLeft-=byVal; // reduce the strength
        
        // if shelter is still strong enough to function ...
        if (strengthLeft>0)
            redraw();  // ... redisplay the shelter
        
        else // shelter not strong enough to function
            getWorld().removeObject(this); // remove this shelter
    }
}
