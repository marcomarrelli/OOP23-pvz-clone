package pvzclone.model.impl;

import pvzclone.model.api.Level;

/**
 * Class that implements a Level.
 * 
 * @author Marco Marrelli
 */
public class LevelImpl implements Level {
    private final int zombieCount;
    private final int zombieWaveCount;
    private final long sunSpawnRate;
    private final long zombieSpawnRate;
    private final long sunSpawnRateDecrementRange;
    private final long zombieSpawnRateDecrementRange;

    private static final double WAVE_PERCENTAGE = 0.3;

    /**
     * Constructor of the Level Implementation.
     * 
     * @param zombieCount the number of zombies
     * @param zombieWaveCount the number of zombie waves
     * @param sunSpawnRate the spawn rate of the sun
     * @param zombieSpawnRate the spawn rate of the zombie
     * @param sunSpawnRateDecrementRange the inc/dec range for suns' s.r.
     * @param zombieSpawnRateDecrementRange the inc/dec range for zombies' s.r.
     */
    public LevelImpl(final int zombieCount, final int zombieWaveCount,
                    final long sunSpawnRate, final long zombieSpawnRate,
                    final long sunSpawnRateDecrementRange,
                    final long zombieSpawnRateDecrementRange) {
        this.zombieCount = zombieCount;
        this.zombieWaveCount = zombieWaveCount;
        this.sunSpawnRate = sunSpawnRate;
        this.sunSpawnRateDecrementRange = sunSpawnRateDecrementRange;
        this.zombieSpawnRate = zombieSpawnRate;
        this.zombieSpawnRateDecrementRange = zombieSpawnRateDecrementRange;
    }

    /**
     * @see Level#getZombieCount()
     */
    @Override
    public int getZombieCount() {
        return this.zombieCount;
    }

    /**
     * @see Level#getZombieWaveCount()
     */
    @Override
    public int getZombieWaveCount() {
        return this.zombieWaveCount;
    }

    /**
     * @see Level#getZombieCountInWave()
     */
    @Override
    public int getZombieCountInWave() {
        return (int) Math.floor(this.getZombieCount() * WAVE_PERCENTAGE);
    }

    /**
     * @see Level#getSunSpawnRate()
     */
    @Override
    public long getSunSpawnRate() {
        return this.sunSpawnRate;
    }

    /**
     * @see Level#getZombieSpawnRate()
     */
    @Override
    public long getZombieSpawnRate() {
        return this.zombieSpawnRate;
    }

    /**
     * @see Level#getSunSpawnRateDecrementRange()
     */
    @Override
    public long getSunSpawnRateDecrementRange() {
        return this.sunSpawnRateDecrementRange;
    }

    /**
     * @see Level#getZombieSpawnRateDecrementRange()
     */
    @Override
    public long getZombieSpawnRateDecrementRange() {
        return this.zombieSpawnRateDecrementRange;
    }
}
