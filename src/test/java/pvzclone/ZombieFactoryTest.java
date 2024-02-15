package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Entities;
import pvzclone.model.api.Zombie;
import pvzclone.model.impl.ZombieImpl;
import pvzclone.model.impl.ZombiesFactory;

/**
 * This class contains tests for testing ZombieFactory.
 * 
 * @author Sofia Lotti.
 */
final class ZombieFactoryTest {

    private static final double ATK = 50;
    private static final int MAX_LIFE = 100;
    private static final int ZOMBIE_SPPED = 2;
    private static final int NUMBER_ENTITIES = 5;

    private static final double DOUBLE_FIFTY = 50.0;
    private static final int INT_FIFTY = 50;
    private static final int HUNDRED = 100;
    private static final int COUNTER = 5;


    private ZombiesFactory newZombiesFactory() {
        return new ZombiesFactory();
    }

    @Test
    void canCreateSingleZombie() {
        final ZombiesFactory factory = newZombiesFactory();
        final Zombie zombie1 = (Zombie) factory.createEntity();
        assertNotNull(zombie1);
        assertTrue(zombie1 instanceof ZombieImpl);
        assertTrue(zombie1.isAlive());
        assertEquals(ATK, zombie1.getDamage());
        assertEquals(MAX_LIFE, zombie1.getRemainingLife());
        zombie1.receiveDamage(INT_FIFTY);
        assertEquals(DOUBLE_FIFTY, zombie1.getRemainingLife());
        for (int x = 0; x < COUNTER; x++) {
            assertTrue(factory.createEntity().isAlive());
            final Zombie cycleZombie = (Zombie) factory.createEntity();
            cycleZombie.receiveDamage(HUNDRED);
            assertFalse(cycleZombie.isAlive());
        }
    }

    @Test
    void canCreateMoreZombies() {
        final ZombiesFactory factory = newZombiesFactory();
        assertNotNull(factory);
        final Set<Entities> setZombie = factory.createEntities(NUMBER_ENTITIES);
        assertEquals(NUMBER_ENTITIES, setZombie.size());
        setZombie.add(factory.createEntity());
        assertEquals(NUMBER_ENTITIES + 1, setZombie.size());

        for (final Entities zombie : setZombie) {
            final var position = zombie.getPosition();
            ((Zombie) zombie).moveLeft();
            assertEquals(zombie.getPosition().getX(), position.getX() - ZOMBIE_SPPED);
        }

    }

}
