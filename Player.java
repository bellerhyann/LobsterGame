import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player class allows player to move lefts and right with the left and right arrows
 * from its location: 
 * user can release a shelter (if the world does not already contain one)
 * user can also release a poison bomb by pressing b (if there is not already a bomb in the world, and you still have bombs left)
 * if a Lobstrosity touches the player, all actors will be removed from the world
 * 
 * @author Belle Erhardt 
 * @version 3/21
 */
public class Player extends Actor
{
    private int Px;
    private int Py;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    int Px = getX();   
    int Py = getY();  
     MyWorld World = (MyWorld) getWorld();
     Shelter shelter = (Shelter) getOneIntersectingObject(Shelter.class);
     PoisonBomb bomb = (PoisonBomb) getOneIntersectingObject(PoisonBomb.class);
     ScoreBoard score = (ScoreBoard) World.getScoreBoard();
        if(Greenfoot.isKeyDown("left"))
        {this.move(-1);}
        if(Greenfoot.isKeyDown("right"))
        {this.move(1);}
        if(Greenfoot.isKeyDown("space")&& !World.containsShelter())
        {
            score.decShelterCount();
            World.addObject(new Shelter(50), Px, Py-35);
        }
        if(Greenfoot.isKeyDown("b") &&  !World.containsBomb() && score.bombsleft()!=0) 
        {
            score.decBombCount(); 
            World.addObject(new PoisonBomb(), Px,Py);
         }
        if(isTouching(Lobstrosity.class))
        {
          World.removeObjects(World.getObjects(Lobstrosity.class));
          World.removeObject(this);
          World.removeObjects(World.getObjects(Shelter.class));
          World.removeObjects(World.getObjects(PoisonBomb.class));
          if(score.getScore()> score.getHighScore())
          {World.getScoreBoard().setHighScore(score.getScore());}
        }

    }    
}
