import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.api.Entities;
import model.api.Zombie;
import model.impl.ZombieImpl;

public final class ZombieTest {
    
    private static final double ATK = 20.0;
    private static final double MAX_LIFE = 100.0;
    private static final int X_SHIFT = 2; /* metri al secondo */
    private static final int COOLDOWN = 10;
    
    private Zombie ZombieEntity(){
        return new ZombieImpl(ATK, COOLDOWN, X_SHIFT, MAX_LIFE, null);
    }

    @Test
    void isZombieAliveWithCorrectValues(){
        Zombie zombie = ZombieEntity();
        assertTrue(zombie.isAlive());
        assertEquals(MAX_LIFE, zombie.getRemainingLife());
        assertEquals(ATK, zombie.getDamage());
        assertEquals(X_SHIFT, zombie.getXShift());
        assertEquals(COOLDOWN, zombie.getCooldown());
        assertEquals("Zombie", zombie.getEntityName());
    }
}
