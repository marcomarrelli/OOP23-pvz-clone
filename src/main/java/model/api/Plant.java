package model.api;

/**
 * interface for the entity plant.
 * 
 * @author Zanchini Margherita
 */
public interface Plant extends ActiveEntities {
    /**
     * @return the time in seconds between the attacks
     */
    double getTimeBetweenAttacks();

}
