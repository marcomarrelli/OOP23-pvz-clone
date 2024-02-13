package model.api;

import java.util.Set;

import model.impl.Pair;

public interface Game {
    /**
     * @return if the game is over (true) or not (false)
     */
    boolean isOver();
    /**
     * update the game
     */
    void update(long elapsed);
    /**
     * create a wave of zombie
     */
    void createWave();
    /**
     * create a new Plant
     */
    void createPlant(Pair<Integer, Integer> position);

    void mouseEvent(Pair<Integer, Integer> posClick);

    GameState getGameState();

    Set<Entities> getEntities();

}
