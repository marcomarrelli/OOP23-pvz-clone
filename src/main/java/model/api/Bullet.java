package model.api;

public interface Bullet extends Entities {
    /**
     * @return the speed of the bullet
     */
    double getSpeed();
    /**
     * @return the damage of the bullet
     */
    double getDamage();
    /**
     * moves the position of the bullet
     */
    void move();

    /**
     * a method that sets the state of the bullet from alive to death
     */
    void killBullet();    
}
