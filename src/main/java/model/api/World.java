package model.api;

/**
 * Interface of the Model of the game.
 * It contains methods to set the Level and Game that will
 * be used to start the game.
 * 
 * @author Sofia Caberletti
 */
public interface World {

    /**
     * Sets the level
     * @param level 
     */
    public void setLevel(Level level);

    /**
     * Sets the game
     * @param game
     */
    public void setGame(Game game);

    /**
     * 
     * @return the level
     */
    public Level getLevel();

    /**
     * 
     * @return the game
     */
    public Game getGame();
    
}
