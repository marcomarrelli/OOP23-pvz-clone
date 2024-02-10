package model.api;

/**
 * This interface models a GameState.
 * Works on the main information related to the game.
 * @author Sofia Lotti.
 */
public interface GameState {
    /**
     * Increases the number of Zombies killed.
     */
    void incKilledZombies();
    /**
     * Increases the available Suns counter.
     */
    void incSunScore();
    /**
     * Decrements the available Suns counter.
     * @param costPlant cost of the chosen plant.
     */
    void decSunScore(final int costPlant);
    /**
     * @return number of Zombies killed.
     */
    int getKilledZombies();
    /**
     * @return Suns counter.
     */
    int getSunScore();


}
