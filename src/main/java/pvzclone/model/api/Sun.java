package pvzclone.model.api;

/**
 * Interface that models a Sun Entity and provides
 * methods to interact with the entity.
 */
public interface Sun extends Entities {
    /**
     * It kills the sun.
     */
    void kill();

    /**
     * @return the points obtained if the sun is touched (killed).
     */
    int getPoints();

    /**
     * It changes the sun position in the y axis towards the bottom.
     */
    void moveDown();

}
