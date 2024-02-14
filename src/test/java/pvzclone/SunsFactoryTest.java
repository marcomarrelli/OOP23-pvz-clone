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

public class SunsFactoryTest {
    private EntitiesFactory sunsFactory;
    private static final int ENTITIES_NUMBER = 5;

    @BeforeEach
    private void initTest() {
        this.sunsFactory = new SunsFactory();
    }

    @Test
    void createSingleSun() {
        final Sun sun = (Sun) this.sunsFactory.createEntity();
        assertNotNull(sun);
        assertTrue(sun instanceof Sun);
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
            assertTrue(s instanceof Entities);
            assertTrue(s instanceof Sun);
            Sun sun = (Sun) s;
            assertTrue(sun.isAlive());
            sun.kill();
            assertFalse(sun.isAlive());
        });
    }
}
