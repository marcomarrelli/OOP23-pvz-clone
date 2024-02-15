package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Bullet;
import pvzclone.model.impl.BulletImpl;
import pvzclone.model.impl.Pair;

/**
 * this class contains the test for the bullet
 * 
 * @author Zanchini Margherita
 */
public class BulletTest {

    private static final int SPEED = 15;
    private static final double DAMAGE = 20;
    private static final Pair<Integer, Integer> POS = new Pair<>(0, 0);
    private static final String NAME = "Bullet";

    private Bullet newBullet() {
        return new BulletImpl(SPEED, DAMAGE, POS, NAME);
    }

    @Test
    void isBulletAliveWithCorrectValues() {
        Bullet bullet = newBullet();
        assertTrue(bullet.isAlive());
        assertEquals(SPEED, bullet.getSpeed());
        assertEquals(DAMAGE, bullet.getDamage());
        assertEquals(POS, bullet.getPosition());
        assertEquals(NAME, bullet.getEntityName());
    }

    @Test
    void correctMovement() {
        Bullet bullet = newBullet();
        bullet.move();
        assertEquals(new Pair<>(POS.getX() + SPEED, POS.getY()), bullet.getPosition());
    }

}
