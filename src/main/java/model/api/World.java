package model.api;

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
