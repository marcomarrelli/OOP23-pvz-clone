package pvzclone.model.impl;

import java.util.Optional;

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
    private static final int INITIAL_SUNS = 100;
    private final int totZombies;
    private int killedZombies;
    private int zombiesGenerated;
    private int sunScore;

    private Optional<Boolean> winState;

    /**
     * Constructor of GameStateImpl.
     * 
     * @param totZombies number of zombies in the level.
     */
    public GameStateImpl(final int totZombies) {
        this.totZombies = totZombies;
        this.killedZombies = 0;
        this.sunScore = INITIAL_SUNS;
        this.winState = Optional.empty();
    }

    @Override
    public void incZombiesGenerated() {
        this.zombiesGenerated = this.zombiesGenerated + 1;
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
    public int getZombiesGenerated() {
        return this.zombiesGenerated;
    }

    @Override
    public boolean areZombieAllKilled() {
        return this.totZombies == this.killedZombies;
    }

    @Override
    public void setWinState(final boolean winState) {
        this.winState = Optional.of(winState);
    }

    @Override
    public Optional<Boolean> getWinState() {
        if (this.winState.isPresent()) {
            return this.winState;
        } else {
            return Optional.empty();
        }
    }
}
