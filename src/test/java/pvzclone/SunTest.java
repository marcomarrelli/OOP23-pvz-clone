package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Sun;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.SunImpl;

/**
 * This class contains tests for the Sun entity.
 */
final class SunTest {
    private static final String NAME = "Sun";
    private static final int POINTS = 25;
    private static final int SCREEN_BOTTOM = 700;
    private static final int IMAGE_HEIGHT = 150;
    private static final int X_POSITION = 40;
    private static final int Y_POSITION = 540;
    private static final Pair<Integer, Integer> POSITION = new Pair<>(X_POSITION, Y_POSITION);
    private static final int SPEED = 5;
    private final Sun sun = new SunImpl(POSITION, SPEED);

    @Test
    void isSunAliveWithCorrectValues() {
        assertTrue(sun.isAlive());
        assertEquals(NAME, sun.getEntityName());
        assertEquals(POSITION, sun.getPosition());
    }

    @Test
    void correctMovement() {
        assertEquals(POSITION, sun.getPosition());
        sun.moveDown();
        assertEquals(X_POSITION, sun.getPosition().getX());
        assertEquals(Y_POSITION + SPEED, sun.getPosition().getY());
        assertTrue(sun.isAlive());
        sun.moveDown();
        assertEquals(X_POSITION, sun.getPosition().getX());
        assertEquals(SCREEN_BOTTOM, sun.getPosition().getY() + IMAGE_HEIGHT);
        assertFalse(sun.isAlive());
    }

    @Test
    void correctRetrievalOfPoints() {
        assertTrue(sun.isAlive());
        assertEquals(0, sun.getPoints());
        sun.kill();
        assertEquals(POINTS, sun.getPoints());
        final Sun sun2 = new SunImpl(new Pair<>(X_POSITION, SCREEN_BOTTOM), 5);
        assertEquals(0, sun2.getPoints());
    }

}
