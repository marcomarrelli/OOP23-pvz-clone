package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pvzclone.model.api.Game;
import pvzclone.model.api.Level;
import pvzclone.model.api.World;
import pvzclone.model.impl.GameImpl;
import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.WorldImpl;

/**
 * this class contains the test for the GameImpl
 * 
 */
public class GameTest {

    private static final int ZOMBIE_COUNT = 5;
    private static final long SUN_SPAWN_RATE = 3000;
    private static final long ZOMBIE_SPAWN_RATE = 13_000;
    private static final long SUN_SPAWN_RATE_DECREMENT_RANGE = 25;
    private static final long ZOMBIE_SPAWN_RATE_DECREMENT_RANGE = 75;

    private World world;
    private Game game;
    private Level level;

    @BeforeEach
    void setUp() {
        world = new WorldImpl();
        level = new LevelImpl(ZOMBIE_COUNT, 1, SUN_SPAWN_RATE, ZOMBIE_SPAWN_RATE, SUN_SPAWN_RATE_DECREMENT_RANGE,
                ZOMBIE_SPAWN_RATE_DECREMENT_RANGE);
        world.setLevel(level);
        game = new GameImpl(world);

    }

    @Test
    void correctCreateEntity() {
        game.update(1000);
        game.createPlant(new Pair<Integer,Integer>(0, 0));
        assertEquals(1, game.getEntities().size());
    }
}
