
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.api.Entities;
import model.api.Zombie;
import model.impl.ZombieImpl;
import model.impl.ZombiesFactory;

/**
 * This class contains tests for testing ZombieFactory.
 * 
 * @author Sofia Lotti.
 */
public final class ZombieFactoryTest {

    private static final double ATK = 20.0;
    private static final double MAX_LIFE = 100.0;
    private static final int ZOMBIE_SPPED = 2;
    private static final int NUMBER_ENTITIES = 5;

    private static final double DOUBLE_FIFTY = 50.0;
    private static final int INT_FIFTY = 50;
    private static final int HUNDRED = 100;
    private static final int COUNTER = 5;

    private ZombiesFactory factory;

    private ZombiesFactory createZombies() {
        return new ZombiesFactory();
    }

    @BeforeEach
    void initFactory() {
        this.factory = createZombies();
    }

    @Test
    void canCreateSingleZombie() {
        // ZombiesFactory zombieCreate = createZombies();
        Zombie zombie1 = (Zombie) factory.createEntity();
        assertNotNull(zombie1);
        assertTrue(zombie1 instanceof ZombieImpl);
        assertTrue(zombie1.isAlive());
        assertEquals(ATK, zombie1.getDamage());
        assertEquals(MAX_LIFE, zombie1.getRemainingLife());
        zombie1.receiveDamage(INT_FIFTY);
        assertEquals(DOUBLE_FIFTY, zombie1.getRemainingLife());
        for (int x = 0; x < COUNTER; x++) {
            assertTrue(createZombies().createEntity().isAlive());
            Zombie cycleZombie = (Zombie) createZombies().createEntity();
            cycleZombie.receiveDamage(HUNDRED);
            assertFalse(cycleZombie.isAlive());
        }
    }

    @Test
    void canCreateMoreZombies() {
        Set<Entities> setZombie = factory.createEntities(NUMBER_ENTITIES);
        assertEquals(NUMBER_ENTITIES, setZombie.size());
        setZombie.add(factory.createEntity());
        assertEquals(NUMBER_ENTITIES + 1, setZombie.size());

        for (Entities zombie : setZombie) {
            assertTrue(zombie instanceof Entities);
            assertTrue(zombie instanceof Zombie);
            var position = zombie.getPosition();
            ((Zombie) zombie).moveLeft();
            assertTrue(zombie.getPosition().getX().equals(position.getX() - ZOMBIE_SPPED));
        }

    }

}
