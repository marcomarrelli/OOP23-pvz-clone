package pvzclone.model.api;

/**
 * This interface models a Level.
 */
public interface Level {
    /**
     * Returns the number of zombies in one level.
     * 
     * @return the number of zombies in one level.
     */
    int getZombieCount();

    /**
     * Returns the number of zombie waves in one level.
     * 
     * @return the numbers of zombie waves in one level.
     */
    int getZombieWaveCount();

    /**
     * Returns the number of zombies in a wave in the level.
     * The value is based on the zombie count.
     * 
     * @return the number of zombies in a wave in the level.
     */
    int getZombieCountInWave();

    /**
     * Returns the sun spawn rate.
     * 
     * @return the sun spawn rate.
     */
    long getSunSpawnRate();

    /**
     * Returns the zombie spawn rate.
     * 
     * @return the zombie spawn rate.
     */
    long getZombieSpawnRate();

    /**
     * Returns the sun decrement spawn rate.
     * 
     * @return the sun decrement spawn rate.
     */
    long getSunSpawnRateDecrementRange();

    /**
     * Returns the zombie decrement spawn rate.
     * 
     * @return the zombie decrement spawn rate.
     */
    long getZombieSpawnRateDecrementRange();
}
