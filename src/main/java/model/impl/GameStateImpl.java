package model.impl;

import model.api.GameState;
import model.api.World;
/**
 * Class that implements GameState.
 * 
 * This class supports reading and writing operations on fields.
 */
public class GameStateImpl implements GameState {

    private static final int INC_SUN = 25;
    private final World world;
    private final int totZombies;
    private int killedZombies;
    private int sunScore;
    /**
     * Constructor of GameStateImpl.
     * @param totZombies number of zombies in the level.
     * @param world World class istance.
     */
    public GameStateImpl(final int totZombies, final World world) {
        this.world= world;
        this.totZombies=totZombies;
        this.killedZombies=0;
        this.sunScore=0;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void incKilledZombies() {
        this.killedZombies = this.killedZombies + 1;    
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void incSunScore() {
        this.sunScore = this.sunScore + INC_SUN;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void decSunScore(int costPlant) {
        this.sunScore = this.sunScore - costPlant;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getKilledZombies() {
        return this.killedZombies;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getSunScore() {
        return this.sunScore;
    }

    
}
