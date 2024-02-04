package model.api;

import javafx.util.Pair;

public interface Game {
    
    /**
     * 
     * @return if the game is over (true) or not (false)
     */
    public boolean isOver();

    /**
     * update the game
     */
    public void update();

    /**
     * create a wave of zombie
     */
    public void createWave();

    /**
     * create a new Plant
     */
    public void createPlant(Pair<Double, Double> position);


}
