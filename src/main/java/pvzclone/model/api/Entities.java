package pvzclone.model.api;

import pvzclone.model.impl.Pair;

/**
 * This interface models a generic entity.
 * Contains methods common to all entities.
 * 
 * @author Sofia Lotti.
 */
public interface Entities {
    /**
     * @return position of the entity
     */
    Pair<Integer, Integer> getPosition();
    /**
     * @return state alive of the entity.
     */
    boolean isAlive();
    /**
     * @return name of the entity.
     */
    String getEntityName();
}
