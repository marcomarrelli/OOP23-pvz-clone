package pvzclone.controller.api;

import java.util.Set;

import pvzclone.input.api.ViewEventListener;
import pvzclone.model.api.Entities;
import pvzclone.model.api.World;
import pvzclone.model.impl.Pair;

/**
 * This interface models a Controller for the game.
 * It extends the ViewEventListener interface.
 */
public interface Controller extends ViewEventListener {

    /**
     * Initializes the game.
     * This method should be called once to start the game.
     */
    void initGame();

    /**
     * Calls the main loop of the game.
     * This method should be called after the game is initialized.
     * It is responsible for managing the game loop.
     */
    void callMainloop();

    /**
     * Retrieves the set of entities in the game.
     * Entities represent the elements present in the game world.
     *
     * @return a Set of Entities representing the elements in the game world.
     */
    Set<Entities> getEntities();

    /**
     * Retrieves the pricipal class of the game model.
     * 
     * @return world of the game.
     */
    World getWorld();

    /**
     * this method communicate with the model
     * telling him the position of the new plant
     * 
     * @param pos is the position of the new plant
     */
    void newPlant(Pair<Integer, Integer> pos);
}
