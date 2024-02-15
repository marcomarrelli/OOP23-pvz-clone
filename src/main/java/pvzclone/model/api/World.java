package pvzclone.model.api;

import pvzclone.model.impl.LevelsManager;

/**
 * Interface of the Model of the game.
 * It contains methods to set the Level and Game that will
 * be used to start the game.
 * 
 * @author Sofia Caberletti.
 */
public interface World {
    /**
     * Sets the level.
     * 
     * @param level level of the World.
     */
    void setLevel(Level level);

    /**
     * Sets the game.
     * 
     * @param game the game of the World.
     */
    void setGame(Game game);

    /**
     * Sets the level manager.
     * 
     * @param levelsManager the level manager of the World.
     */
    void setLevelsManager(LevelsManager levelsManager);

    /**
     * @return the level.
     */
    Level getLevel();

    /**
     * @return the game.
     */
    Game getGame();

    /**
     * @return the level manager.
     */
    LevelsManager getLevelsManager();
}
