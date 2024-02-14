package pvzclone.model.impl;

import pvzclone.model.api.GameState;

/**
 * Class that implements GameState.
 * 
 * This class supports reading and writing operations on fields.
 * 
 * @author Sofia Lotti.
 */
public final class GameStateImpl implements GameState {

    private static final int INC_SUN = 25;
    private final int totZombies;
    private int killedZombies;
    private int sunScore;

    /**
     * Constructor of GameStateImpl.
     * 
     * @param totZombies number of zombies in the level.
     */
    public GameStateImpl(final int totZombies) {
        this.totZombies = totZombies;
        this.killedZombies = 0;
        this.sunScore = 75;
    }

    @Override
    public void incKilledZombies() {
        this.killedZombies = this.killedZombies + 1;
    }

    @Override
    public void incSunScore() {
        this.sunScore = this.sunScore + INC_SUN;
    }

    @Override
    public void decSunScore(final int costPlant) {
        this.sunScore = this.sunScore - costPlant;
    }

    @Override
    public int getKilledZombies() {
        return this.killedZombies;
    }

    @Override
    public int getSunScore() {
        return this.sunScore;
    }

    @Override
    public boolean areZombieAllKilled() {
        return this.totZombies == this.killedZombies;
    }
}
