import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * MyWorld is the "canvas" upon whicg CSC14400 project 1 is built. 
 * It allows for a player to mive left and right, lobstrosity
 * monsters to "fall" down the screen and kill the player, shelters
 * to be built and poinson bombs to be thrown.
 * 
 * @author Stephen Blythe, Belle Erhardt
 * @version 1/2020
 */
public class MyWorld extends World
{
    private Lobstrosity Lobster;
    private ScoreBoard scoreboard;
    private int worldHeight;
    private int worldWidth;
    private int LobY;
    private Player player;
    Random d = new Random();
    
    
    /**
     * Constructor for objects of class MyWorld.
     * constructs a 800x600 pixel world, starting off with lobster and a player in the 
     * middle of the world. As well as a scoreboard at the top of the world.
     * 
     *
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        int worldHeight = this.getHeight();
        int worldWidth = this.getWidth();
        Player player = new Player();
        Lobstrosity Lobster = new Lobstrosity();
        ScoreBoard scoreboard = new ScoreBoard();
        addObject(player, worldWidth/2,550);
        addObject(Lobster, this.getWidth()/2, d.nextInt(200)+41);
        Lobster.setRotation(90);
        addObject(scoreboard, worldWidth/2, getHeight()/getHeight()+10);
    }
    
    /**getLobster allows us to call this lobster later by
     * returning an instance of lobstrosity
     */
    public Lobstrosity getLobster()
    {
        return  Lobster; 

    }
    
    /**
     * containsShelter tells us whether or not a shelter
     *  is already in the world. 
     * @return true if there is a shelter, false if not
     */
    
    public boolean containsShelter()
    {
        // fairly inelegant and inefficient way to code this
        // but avoids the need for code elsewhere. 
        return (!getObjects(Shelter.class).isEmpty());
    }
    
    /**
     * containsBomb tells us whether or not a bomb
     *       is already in the world. 
     * @return true if there is a bomb, false if not
     */
    public boolean containsBomb()
    {
        // fairly inelegant and inefficient way to code this
        // but avoids the need for code elsewhere. 
        return (!getObjects(PoisonBomb.class).isEmpty());
    }
    
    /**
     * lobstrosityCount tells us how many lobstrosities are 
     * in the World.
     * @return the number of lobstrosities in the world
     */
    public int lobstrosityCount()
    {
        return getObjects(Lobstrosity.class).size();
    }
    
    /**
     * getScoreBoard gives us the Scoreboard found in the world
     *   
     * @return the ScoreBoard object seen in the world
     */
    public ScoreBoard getScoreBoard()
    {
        return getObjects(ScoreBoard.class).get(0);
    }
    
    /**
     * removeLobstrosities removes every Lobstrosity
     */
    public void removeLobstrosities()
    {
        removeObjects(getObjects(Lobstrosity.class));
    }
    
    
    /**
     * removeShelters removes every Shelter
     */
    public void removeShelters()
    {
        removeObjects(getObjects(Shelter.class));
    }
    

    /**
     * addLobster adds a new Lobster at a random point in the world
     */
    public void addLobster()
    {
        Random d = new Random();
        Lobstrosity Lobby = new Lobstrosity();
        addObject(Lobby, d.nextInt(738)+38, d.nextInt(200)+41);
    }
    
    /**
     * removeBombs removes every PoisonBomb
     */
    public void removeBombs()
    {
        removeObjects(getObjects(PoisonBomb.class));
    }

    /**
     * If n is pressed after you die
     * a new lobster and player will apear on the screen
     * and the scoreboard will keep any (new) highscore for 
     * the next rounds of play. Shelter and bomb counts will return to original numbers
     * 
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("n") &&  lobstrosityCount()==0)
        {
            Random d = new Random();
            Lobstrosity lobby = new Lobstrosity();
            int worldWidth = this.getWidth();
            getScoreBoard().resetForNewGame();
            addObject(lobby, worldWidth/2, d.nextInt(200)+41);
            Player player = new Player();
            addObject(player, worldWidth/2,550);
        }
        }
        
        
  } 

