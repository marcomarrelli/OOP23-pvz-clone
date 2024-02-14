package pvzclone.model.api;

/**
 * interface for the entity plant.
 * 
 * @author Zanchini Margherita
 */
public interface Plant extends ActiveEntities {

    /**
     * Returns the cost of the plant.
     * 
     * @return cost to buy the plant.
     */
    int getPlantCost();
}
