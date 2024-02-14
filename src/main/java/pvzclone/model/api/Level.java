package pvzclone.model.api;

/**
 * This interface models a Level.
 */
public interface Level {
    /**
     * @return the World to which the level is associated.
     */
    World getWorld();
    /**
     * @return the numbers of zombie in one level.
     */
    int getZombieCount();

}
