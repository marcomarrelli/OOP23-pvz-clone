package pvzclone.model.api;

/**
 * This interface models a Level.
 * 
 * @author Marco Marrelli
 */
public interface Level {
    /**
     * Returns the numbers of zombie in one level.
     * 
     * @return the numbers of zombie in one level.
     */
    int getZombieCount();

    /**
     * Returns the numbers of zombie waves in one level.
     * The value is based on the zombie count.
     * 
     * @return the numbers of zombie waves in one level.
     */
    int getZombieWaveCount();

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
     * Returns the sun spawn rate.
     * 
     * @return the sun decrement spawn rate.
     */
    long getSunSpawnRateDecrementRange();
    
    /**
     * Returns the zombie spawn rate.
     * 
     * @return the zombie decrement spawn rate.
     */
    long getZombieSpawnRateDecrementRange();
}
