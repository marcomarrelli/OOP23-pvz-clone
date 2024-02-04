package model.api;

import javafx.util.Pair;

public interface Entities {
    
    /**
     * must change return
     */
    public Pair<Double,Double> getPosition();

    /**
     * 
     * @return
     */
    public boolean isAlive();

    /**
     * 
     * @return name of the entity
     */
    public String getEntityName();


}
