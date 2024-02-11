package model.api;
/**
 * This interface models a Zombie Entity.
 * @author Sofia Lotti.
 */
public interface Zombie extends ActiveEntities {
    /**
     * Moves Zombie to the left.
     */
    void moveLeft();
    /**
     * @return delta, the shift of the Zombie in X axis.
     */
    double getXShift();

}
