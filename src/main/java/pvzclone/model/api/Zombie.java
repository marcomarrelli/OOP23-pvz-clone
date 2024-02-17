package pvzclone.model.api;

/**
 * This interface models a Zombie Entity.
 */
public interface Zombie extends ActiveEntities {
    /**
     * Moves Zombie to the left.
     */
    void moveLeft();

    /**
     * Sets the boolean based on whether the Zombie can move or not.
     * 
     * @param canGo true if Zombie can move, false otherwise.
     */
    void setCanGo(boolean canGo);

    /**
     * @return boolean canGo, which tells us if Zombie can move or not.
     */
    boolean isCanGo();

}
