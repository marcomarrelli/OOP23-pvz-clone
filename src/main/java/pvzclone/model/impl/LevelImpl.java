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

    private static final int WAVE_PERCENTAGE = 40;

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

    @Override
    public int getZombieCount() {
        return this.zombieCount;
    }

    @Override
    public int getZombieWaveCount() {
        return this.zombieWaveCount;
    }

    @Override
    public int getZombieCountInWave() {
        return (int) (this.getZombieCount() * WAVE_PERCENTAGE) / 100;
    }

    @Override
    public long getSunSpawnRate() {
        return this.sunSpawnRate;
    }

    @Override
    public long getZombieSpawnRate() {
        return this.zombieSpawnRate;
    }

    @Override
    public long getSunSpawnRateDecrementRange() {
        return this.sunSpawnRateDecrementRange;
    }

    @Override
    public long getZombieSpawnRateDecrementRange() {
        return this.zombieSpawnRateDecrementRange;
    }
}
