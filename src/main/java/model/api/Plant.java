package model.api;

public interface Plant extends ActiveEntities {
    /**
     * @return the time in seconds between the attacks
     */
    public double getTimeBetweenAttacks();
    
}
