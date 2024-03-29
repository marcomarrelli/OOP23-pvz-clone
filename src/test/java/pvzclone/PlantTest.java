package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Plant;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.PlantImpl;

/**
 * This class contains the test for the plant.
 */
final class PlantTest {

    private static final double DAMAGE = 20;
    private static final double LIFE = 100;
    private static final String NAME = "plant";
    private static final Pair<Integer, Integer> POS = new Pair<>(0, 0);
    private static final long COOLDOWN = 3000;

    private final Plant plant = new PlantImpl(DAMAGE, LIFE, NAME, POS, COOLDOWN);

    @Test
    void isPlantAliveWithCorrectValues() {
        assertTrue(plant.isAlive());
        assertEquals(DAMAGE, plant.getDamage());
        assertEquals(LIFE, plant.getRemainingLife());
        assertEquals(NAME, plant.getEntityName());
        assertEquals(POS, plant.getPosition());
        assertEquals(COOLDOWN, plant.getCooldown());
    }

    @Test
    void correctDecreaseLife() {
        plant.receiveDamage(DAMAGE);
        assertTrue(plant.isAlive());
        assertEquals(LIFE - DAMAGE, plant.getRemainingLife());
        plant.receiveDamage(LIFE);
        assertTrue(plant.getRemainingLife() < 0);
        assertFalse(plant.isAlive());
    }

}
