package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pvzclone.model.api.Sun;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.SunImpl;

public class SunTest {
    private static final String NAME = "Sun";
    private static final int POINTS = 25;
    private static final int SCREEN_BOTTOM = 700;
    private static final int IMAGE_HEIGHT = 150;
    private static final int X_POSITION = 40;
    private static final int Y_POSITION = 540;
    private static final Pair<Integer, Integer> POSITION = new Pair<>(X_POSITION, Y_POSITION);
    private static final int SPEED = 5;
    private Sun sun;

    @BeforeEach
    private void initTest() {
        this.sun = new SunImpl(POSITION, SPEED);
    }

    @Test
    void isSunAliveWithCorrectValues() {
        assertTrue(this.sun.isAlive());
        assertEquals(NAME, this.sun.getEntityName());
        assertEquals(POSITION, this.sun.getPosition());
        assertEquals(SPEED, this.sun.getSpeed());
    }

    @Test
    void correctMovement() {
        assertEquals(POSITION, this.sun.getPosition());
        this.sun.moveDown();
        assertEquals(X_POSITION, this.sun.getPosition().getX());
        assertEquals(Y_POSITION + SPEED, this.sun.getPosition().getY());
        assertTrue(this.sun.isAlive());
        this.sun.moveDown();
        assertEquals(X_POSITION, this.sun.getPosition().getX());
        assertEquals(SCREEN_BOTTOM, this.sun.getPosition().getY() + IMAGE_HEIGHT);
        assertFalse(this.sun.isAlive());
    }

    @Test
    void correctRetrievalOfPoints() {
        assertTrue(this.sun.isAlive());
        assertEquals(0, this.sun.getPoints());
        this.sun.kill();
        assertEquals(POINTS, this.sun.getPoints());
        final Sun sun2 = new SunImpl(new Pair<>(X_POSITION, SCREEN_BOTTOM), 5);
        assertEquals(0, sun2.getPoints());
    }

}
