import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The top ScoreBoard for CSC14400 Spring 2020 Project 1. It keeps
 *   track of the game score, the high score, the number of
 *   shelters left, and the number of bombs left. 
 * 
 * Although you are welcome to modify this class, IT IS **HIGHLY**
 * INADVISABLE THAT YOU MODIFY THIS CLASS. 
 * 
 * @author Stephen Blythe
 * @version 1/2020
 */
public class ScoreBoard extends Actor
{
    private int gameScore;      // current game score
    private int highScore;      // high score so far
    private int sheltersLeft;   // number of shelters left
    private int bombsLeft;      // number of bombs left
    
    // "global" representing the height (bottom to top) of a 
    // ScoreBoard
    public static final int SCOREBOARD_HEIGHT = 25;

    /**
     * Constructor for ScoreBoard to build starting scoreboard.
     */
    public ScoreBoard()
    {
       gameScore=0;     // no game started yet, so score is 0
       highScore=0;     // no game started yet, so high score is 0
       bombsLeft=10;    // no game started yet, so all bombs available
       sheltersLeft=3;  // no game started yet, so all shelters available
    }
    
    /**
     * returns how many bombs left on the scoreboard
     */
    public int bombsleft()
    {return bombsLeft;}
    // Greenfoot trick to draw image ater object added to world. 
    protected void addedToWorld(World toWorld)
    {
        redraw();
    }
    
    // redraws scoreboard, updating values displayed as we go
    //   we don't want this called from outside the class, so
    //   it is private in this case. 
    private void redraw()
    {
        // needs regular access to world, so store in a variable. 
        MyWorld placedIn = (MyWorld) getWorld();
        
        // check to see if image is valid. If not, rebuild it.
        GreenfootImage img = getImage();
        if (img==null || 
            img.getWidth()!= placedIn.getWidth() ||
            img.getHeight()!=SCOREBOARD_HEIGHT)
        {
            img = new GreenfootImage(placedIn.getWidth(), SCOREBOARD_HEIGHT);
            setImage(img);
        }
        
        // fill image with gray background
        img.setColor(Color.LIGHT_GRAY);
        img.fill();
        
        // draw scores, etc. in black
        img.setColor(Color.BLACK);
        img.drawString("Score:"+ gameScore, 600, SCOREBOARD_HEIGHT-8);
        img.drawString("High Score:"+ highScore, 400, SCOREBOARD_HEIGHT-8);

        // draw in shelter and bomb stats
        img.drawString("Shelters:"+ sheltersLeft, 100, SCOREBOARD_HEIGHT-8);
        img.drawString("Bombs:"+ bombsLeft, 300, SCOREBOARD_HEIGHT-8);
    }
    
    /**
     * incScore - adds something to score
     * @param byVal - value to add to the score. 
     */
    public void incScore(int byVal)
    {
        gameScore+=byVal;
        redraw();
    }
    
    /**
     * getScore - returns the current score
     * @return the current game score 
     */
    public int getScore()
    {
        return gameScore;
    }
    
    /**
     * decBombCount - decrease the number of bombs by 1, but only
     *                  if there are any bombs left
     * @return true when there was at least 1 bomb left, 
     *         false otherwise
     */
    public boolean decBombCount()
    {
        // if there are bombs left  
        if (bombsLeft>0)
        {
            bombsLeft--; // reduce bomb count
            redraw(); // redraw image to see updated bomb count
            return true; // we succeeded!
        }
        return false; // not enough bombs to do this!
    }
    
    /**
     * decShelterCount - decrease the number of shelters by 1, but
     *                  only if there are any shelters left
     * @return true when there was at least 1 shelter left, 
     *         false otherwise
     */
    public boolean decShelterCount()
    {
        // if there are shelters left  
        if (sheltersLeft>0)
        {
            sheltersLeft--; // now there's one less shelter
            redraw();       // redraw to reflect change 
            return true;    // we had a shelter left!
        }
        return false; // no shlters left!
    }
    
    /**
     * getShelterCount returns how mny shelters are available
     * 
     * @return the current number of shelters
     */
    public int getShelterCount()
    {
        return sheltersLeft;
    }
    
    /**
     * getHighScore  returns the current value of high score
     * 
     * @return the current high score
     */
    public int getHighScore()
    {
        return highScore;
    }
    
    
    /**
     * setHighScore gives high score a new value
     * 
     * @param newScore the intended new value of high score
     */
    public void setHighScore(int newScore)
    {
        highScore = newScore; // store the new high score
        redraw();             // redisplay scoreboard
    }
    
    /**
     * resetForNewGame resets the scoreboard data for a new game
     *      * note that this does NOT reset high score
     */
    public void resetForNewGame() 
    {
        // games start with 3 shelters, 10 bombs, and a score of 0
        sheltersLeft=3;
        bombsLeft=10;
        gameScore=0;
        
        redraw();  // redisplay the scoreboard. 
    }

}
