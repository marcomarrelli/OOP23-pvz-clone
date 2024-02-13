package controller.api;

import java.util.Set;

import input.api.ViewEventListener;
import model.api.Entities;

/**
 * This interface models a Controller for the game.
 * It extends the ViewEventListener interface.
 */
public interface Controller extends ViewEventListener {

    /**
     * Initializes the game.
     * This method should be called once to start the game.
     * It may throw an Exception if there is an error during initialization.
     *
     * @throws Exception if there is an error during game initialization.
     */
    void initGame() throws Exception;

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
}
