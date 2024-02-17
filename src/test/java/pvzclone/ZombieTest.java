package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Zombie;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.ZombieImpl;

/**
 * This class contains tests for testing Zombie.
 */
final class ZombieTest {

    private static final double ATK = 20.0;
    private static final double MAX_LIFE = 100.0;
    private static final int X_SHIFT = 2;
    private static final int COOLDOWN = 10;
    private static final Pair<Integer, Integer> POSITION = new Pair<>(50, 50);

    private static final int DAMAGE_RECEIVED = 10;
    private static final int INT_FIFTY = 50;
    private static final int FIRST_X_COORD = 48;
    private static final int SECOND_X_COORD = 28;

    private Zombie zombieEntity() {
        return new ZombieImpl(ATK, COOLDOWN, X_SHIFT, MAX_LIFE, POSITION);
    }

    @Test
    void isZombieAliveWithCorrectValues() {
        final Zombie zombie = zombieEntity();
        assertTrue(zombie.isAlive());
        assertEquals(MAX_LIFE, zombie.getRemainingLife());
        assertEquals(ATK, zombie.getDamage());
        assertEquals(COOLDOWN, zombie.getCooldown());
        assertEquals("Zombie", zombie.getEntityName());
    }

    @Test
    void correctDecreaseLife() {
        final Zombie zombie = zombieEntity();
        assertTrue(zombie.isAlive());
        assertEquals(MAX_LIFE, zombie.getRemainingLife());
        zombie.receiveDamage(DAMAGE_RECEIVED);
        assertEquals(MAX_LIFE - DAMAGE_RECEIVED, zombie.getRemainingLife());
        zombie.receiveDamage(DAMAGE_RECEIVED);
        zombie.receiveDamage(DAMAGE_RECEIVED);
        zombie.receiveDamage(DAMAGE_RECEIVED);
        zombie.receiveDamage(DAMAGE_RECEIVED);
        assertEquals(INT_FIFTY, zombie.getRemainingLife());
        assertTrue(zombie.isAlive());
        zombie.receiveDamage(INT_FIFTY);
        assertFalse(zombie.isAlive());
    }

    @Test
    void correctMovementZombie() {
        final Zombie zombie = zombieEntity();
        assertEquals(POSITION, zombie.getPosition());
        zombie.moveLeft();
        assertEquals(new Pair<>(FIRST_X_COORD, INT_FIFTY), zombie.getPosition());
        for (int i = 0; i < DAMAGE_RECEIVED; i++) {
            zombie.moveLeft();
        }
        assertEquals(new Pair<>(SECOND_X_COORD, INT_FIFTY), zombie.getPosition());
    }

    @Test
    void createALotOfZombies() {
        // Set<Zombie> zombies = new HashSet<>();
        final Zombie zombie1 = zombieEntity();
        final Zombie zombie2 = zombieEntity();
        final Zombie zombie3 = zombieEntity();

        assertTrue(zombie1.isAlive());
        assertTrue(zombie2.isAlive());
        assertTrue(zombie3.isAlive());

    }
}
