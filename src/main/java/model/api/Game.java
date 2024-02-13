package model.api;

import java.util.Set;

import model.impl.Pair;

/**
 * interface for the game.
 */
public interface Game {
    /**
     * @return if the game is over (true) or not (false).
     */
    boolean isOver();

    /**
     * update the whole game.
     * 
     * @param elapsed is the current time
     */
    void update(long elapsed);

    /**
     * create a wave of zombie.
     */
    void createWave();

    /**
     * create a new plant.
     * 
     * @param position is the position of the new plant
     */
    void createPlant(Pair<Integer, Integer> position);

    /**
     * is check what type the mouse event is.
     * 
     * @param posClick is the position of the mouse click
     */
    void mouseEvent(Pair<Integer, Integer> posClick);

    /**
     * 
     * @return the GameState
     */
    GameState getGameState();

    /**
     * 
     * @return the set of all the entities
     */
    Set<Entities> getEntities();

}
