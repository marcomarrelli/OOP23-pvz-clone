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
     * Create a new plant.
     * 
     * @param position is the position of the new plant
     * @return true if the plant is created, else false
     */
    boolean createPlant(Pair<Integer, Integer> position);

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
