package model.api;

import model.impl.Pair;

public interface Game {
    /**
     * @return if the game is over (true) or not (false)
     */
    boolean isOver();
    /**
     * update the game
     */
    void update();
    /**
     * create a wave of zombie
     */
    void createWave();
    /**
     * create a new Plant
     */
    void createPlant(Pair<Double, Double> position);

    void mouseEvent(Pair<Double, Double> posClick);

    void checkCollision();

    GameState getGameState();

}
