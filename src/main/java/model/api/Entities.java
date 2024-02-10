package model.api;

import model.impl.Pair;
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
    public Pair<Double,Double> getPosition();
    /**
     * @return state alive of the entity.
     */
    public boolean isAlive();
    /**
     * @return name of the entity.
     */
    public String getEntityName();


}
