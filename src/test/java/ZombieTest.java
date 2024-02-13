import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.api.Entities;
import model.api.Zombie;
import model.impl.Pair;
import model.impl.ZombieImpl;

public final class ZombieTest {
    
    private static final double ATK = 20.0;
    private static final double MAX_LIFE = 100.0;
    private static final long X_SHIFT = 2; /* metri al secondo */
    private static final long COOLDOWN = 10;
    private static final Pair<Double,Double> POSITION = new Pair<>(50.0, 50.0);
    
    private Zombie ZombieEntity(){
        return new ZombieImpl(ATK, COOLDOWN, X_SHIFT, MAX_LIFE, POSITION);
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

    @Test
    void correctDecreaseLife(){
        Zombie zombie = ZombieEntity();
        assertTrue(zombie.isAlive());
        assertEquals(MAX_LIFE, zombie.getRemainingLife());
        zombie.receiveDamage(10);
        assertEquals(90.0, zombie.getRemainingLife());
        zombie.receiveDamage(40);
        assertEquals(50, zombie.getRemainingLife());
        assertTrue(zombie.isAlive());
        zombie.receiveDamage(50);
        assertFalse(zombie.isAlive());
    }

    @Test
    void correctMovementZombie(){
        Zombie zombie = ZombieEntity();
        assertEquals(POSITION, zombie.getPosition());
        zombie.moveLeft();
        assertEquals(new Pair<>(48.0,50.0), zombie.getPosition());
        for (int i=0; i<10; i++){
            zombie.moveLeft();
        }
        assertEquals(new Pair<>(28.0,50.0), zombie.getPosition());
    }

    @Test
    void createALotOfZombies(){
        Set<Zombie> zombies = new HashSet<>();
        Zombie zombie1 = ZombieEntity();
        Zombie zombie2 = ZombieEntity();
        Zombie zombie3 = ZombieEntity();

        assertTrue(zombie1.isAlive());
        assertTrue(zombie2.isAlive());
        assertTrue(zombie3.isAlive());
        
        
    }
}
