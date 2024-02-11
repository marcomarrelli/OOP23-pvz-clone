package model.api;

import model.impl.Pair;

public interface Game {
    /**
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

    /**
     * @param posClick is the position where the mouse has been clicked on the screen
     * 
     * this method check what type of click:
     * clicked on a sun
     * clicked on the image of the plant
     * clicked on a cell to position the plant chosen
     */
    public void mouseEvent(Pair<Double, Double> posClick);

    public void checkCollision();

    public GameState getGameState();

}
