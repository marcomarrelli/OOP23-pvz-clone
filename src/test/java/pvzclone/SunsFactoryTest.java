package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pvzclone.model.api.Entities;
import pvzclone.model.api.EntitiesFactory;
import pvzclone.model.api.Sun;
import pvzclone.model.impl.SunsFactory;

/**
 * This class contains tests for the SunFactory.
 * 
 * @author Sofia Caberletti.
 */
final class SunsFactoryTest {
    private static final int ENTITIES_NUMBER = 5;
    private EntitiesFactory sunsFactory;

    /**
     * Inizializza sunsFactory prima di ogni test.
     */
    @BeforeEach
    void createSunsFactory() {
        this.sunsFactory = new SunsFactory();
    }

    @Test
    void createSingleSun() {
        final Sun sun = (Sun) this.sunsFactory.createEntity();
        assertNotNull(sun);
        assertTrue(sun.isAlive());
        sun.kill();
        assertFalse(sun.isAlive());
    }

    @Test
    void createMultipleSuns() {
        final Set<Entities> suns = this.sunsFactory.createEntities(ENTITIES_NUMBER);
        assertEquals(ENTITIES_NUMBER, suns.size());
        suns.forEach(s -> {
            assertNotNull(s);
            final Sun sun = (Sun) s;
            assertTrue(sun.isAlive());
            sun.kill();
            assertFalse(sun.isAlive());
        });
    }
}
