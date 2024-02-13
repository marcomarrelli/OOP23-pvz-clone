package pvzclone.model.api;

import java.util.Set;

import pvzclone.model.impl.Pair;

/**
 * This interface models a Game.
 * It represents the core functionality and mechanics of the game.
 */
public interface Game {

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise.
     */
    boolean isOver();

    /**
     * update the whole game.
     * 
     * @param elapsed is the current time
     */
    void update(long elapsed);

    /**
     * Creates a wave of zombies in the game.
     * This method is responsible for spawning a new wave of zombies.
     */
    void createWave();

    /**
     * create a new plant.
     * 
     * @param position is the position of the new plant
     */
    void createPlant(Pair<Integer, Integer> position);

    /**
     * Handles mouse events in the game.
     * This method is called when a mouse event occurs in the game window.
     *
     * @param posClick the position where the mouse click event occurred.
     */
    void mouseEvent(Pair<Integer, Integer> posClick);

    /**
     * Retrieves the current state of the game.
     *
     * @return the current state of the game.
     */
    GameState getGameState();

    /**
     * Retrieves the set of entities present in the game.
     * Entities represent the elements in the game world.
     *
     * @return a Set of Entities representing the elements in the game world.
     */
    Set<Entities> getEntities();
}
