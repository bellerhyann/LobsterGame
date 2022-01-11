import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.Objects;

/**
 * Lobstrosity will move one pixel and check to see if is touching a shelter (if it exists),
 * or a bomb (if it exists in the world), or the bottom of the world.
 * 
 * upon touching the shelter, the lobster will be removed from world, another lobster will be added at random, and the shelter strength will decrease.
 * upon touching a bomb, the lobster(s) will be removed from the world. And another one willbe added.
 * upon touching the bottom of the world, the lobstrosity will be removed and two more will 
 * randomly be added to the world (within the apropriate range)
 * 
 * @author Belle Erhardt
 * @version 3/21
 */
public class Lobstrosity extends Actor
{
    /**
     * turns Lobstrosities to face the bottom of the world
     */
    public Lobstrosity()
    {
        turn(90);
    }
    Random d = new Random();
    /**
     * Act - do whatever the Lostrosity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
     move(1);
     MyWorld World = (MyWorld) getWorld();
     Shelter shelter = (Shelter) getOneIntersectingObject(Shelter.class);
     PoisonBomb bomb = (PoisonBomb) getOneIntersectingObject(PoisonBomb.class);
     if(shelter != null)
     {
      if (World.lobstrosityCount()<=1)
      World.addLobster();
      World.removeObject(this);
      shelter.reduceStrength();
    }
    
    else if (bomb!=null)
    {
     if (World.lobstrosityCount()<=1)
     World.addLobster();
     World.removeObject(this);
    }
    
    else if (getY() >= World.getHeight()-1)
    {
        World.addLobster();
        World.addLobster();
        World.getScoreBoard().incScore(1);
        World.removeObject(this);
    }
     
     }
     }    
    
 

