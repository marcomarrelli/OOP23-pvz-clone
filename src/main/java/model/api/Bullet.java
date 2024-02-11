package model.api;

public interface Bullet extends Entities {

    /**
     * 
     * @return the speed of the bullet
     */
    public double getSpeed();

    /**
     * 
     * @return the damage of the bullet
     */
    double getDamage();

    /**
     * moves the position of the bullet
     */
    void move();
    
}
