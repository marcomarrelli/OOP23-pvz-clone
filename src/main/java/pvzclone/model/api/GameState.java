package pvzclone.model.api;

import java.util.Optional;

/**
 * This interface models a GameState.
 * Works on the main information related to the game.
 * 
 * @author Sofia Lotti.
 */
public interface GameState {
    /**
     * Increases the number of Zombies generated.
     */
    void incZombiesGenerated();

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
     * 
     * @param costPlant cost of the chosen plant.
     */
    void decSunScore(int costPlant);

    /**
     * @return number of Zombies killed.
     */
    int getKilledZombies();

    /**
     * @return Suns counter.
     */
    int getSunScore();

    /**
     * @return number of Zombies generated.
     */
    int getZombiesGenerated();

    /**
     * @return {@true} number of zombies killed is equals
     *         to the effective number to be killed.
     */
    boolean areZombieAllKilled();

    /**
     * Sets the win state of the current game.
     */
    void setWinState(boolean winState);

    /**
     * Returns the win state at the end of the Game.
     * 
     * @return true if player won, false if player lose, Optional.empty if game is not over.
     */
    Optional<Boolean> getWinState();
}
