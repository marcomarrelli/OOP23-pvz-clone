package model.api;

public interface EntitiesFight extends Entities {
    
    /**
     * 
     * @return entity's attack points;
     */
    public double getDamage();

    /**
     * @return entity's health points
     */
    public double getRemainingLife();
}
