package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
class GameTest {

    private static final int ZOMBIE_COUNT = 5;
    private static final long SUN_SPAWN_RATE = 4000;
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
        // the first zombie and the first sun are generated after 4 seconds
        game.update(2000);
        assertEquals(0, game.getEntities().size());
        game.update(5000);
        assertEquals(2, game.getEntities().size());
        assertTrue(game.createPlant(new Pair<Integer, Integer>(0, 0)));
        assertEquals(3, game.getEntities().size());
        // it does not create another plant beacuse we don't have enough sun
        assertFalse(game.createPlant(new Pair<Integer, Integer>(10, 10)));
        assertEquals(3, game.getEntities().size());
        // we increment the sun score
        game.getGameState().incSunScore();
        game.getGameState().incSunScore();
        game.getGameState().incSunScore();
        game.getGameState().incSunScore();
        assertTrue(game.createPlant(new Pair<Integer, Integer>(10, 10)));
    }

    @Test
    void correctIsOver() {
        assertFalse(game.isOver());
        for(int i = 0; i<ZOMBIE_COUNT; i++){
            this.game.getGameState().incKilledZombies();
        }
        assertTrue(game.isOver());
    }
}
