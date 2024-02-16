package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pvzclone.model.api.Game;
import pvzclone.model.api.Level;
import pvzclone.model.api.World;
import pvzclone.model.impl.GameImpl;
import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.WorldImpl;

/**
 * This class contains the test for the GameImpl.
 * 
 * @author Zanchini Margherita
 */
class GameTest {

    private static final int ZOMBIE_COUNT = 5;
    private static final long SUN_SPAWN_RATE = 4000;
    private static final long ZOMBIE_SPAWN_RATE = 13_000;
    private static final long SUN_SPAWN_RATE_DECREMENT_RANGE = 25;
    private static final long ZOMBIE_SPAWN_RATE_DECREMENT_RANGE = 75;
    private static final long FIRST_ELAPSED = 2000;
    private static final long SECOND_ELAPSED = 5000;

    private Game game;

    private void init() {
        final World world = new WorldImpl();
        final Level level = new LevelImpl(ZOMBIE_COUNT, 1, SUN_SPAWN_RATE, ZOMBIE_SPAWN_RATE,
                SUN_SPAWN_RATE_DECREMENT_RANGE,
                ZOMBIE_SPAWN_RATE_DECREMENT_RANGE);
        world.setLevel(level);
        game = new GameImpl(world);
    }

    @Test
    void correctCreateEntity() {
        init();
        final World world = new WorldImpl();
        final Level level = new LevelImpl(ZOMBIE_COUNT, 1, SUN_SPAWN_RATE, ZOMBIE_SPAWN_RATE,
                SUN_SPAWN_RATE_DECREMENT_RANGE,
                ZOMBIE_SPAWN_RATE_DECREMENT_RANGE);
        world.setLevel(level);
        game = new GameImpl(world);
        // the first zombie and the first sun are generated after 4 seconds
        this.game.update(FIRST_ELAPSED);
        assertEquals(0, game.getEntities().size());
        this.game.update(SECOND_ELAPSED);
        assertEquals(2, this.game.getEntities().size());
        assertTrue(game.createPlant(new Pair<Integer, Integer>(0, 0)));
        assertEquals(3, this.game.getEntities().size());
        // it does not create another plant beacuse we don't have enough sun
        assertFalse(this.game.createPlant(new Pair<Integer, Integer>(10, 10)));
        assertEquals(3, this.game.getEntities().size());
        // we increment the sun score
        this.game.getGameState().incSunScore();
        this.game.getGameState().incSunScore();
        this.game.getGameState().incSunScore();
        this.game.getGameState().incSunScore();
        assertTrue(game.createPlant(new Pair<Integer, Integer>(10, 10)));
    }

    @Test
    void correctIsOver() {
        init();
        assertFalse(this.game.isOver());
        for (int i = 0; i < ZOMBIE_COUNT; i++) {
            this.game.getGameState().incKilledZombies();
        }
        assertTrue(this.game.isOver());
    }
}
