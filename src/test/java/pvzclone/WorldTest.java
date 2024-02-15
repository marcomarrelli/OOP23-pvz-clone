package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pvzclone.model.api.Game;
import pvzclone.model.api.Level;
import pvzclone.model.api.World;
import pvzclone.model.impl.GameImpl;
import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.LevelsManager;
import pvzclone.model.impl.WorldImpl;

/**
 * This class contains tests for the class WorldImpl.
 * 
 * @author Sofia Caberletti.
 */
public class WorldTest {
    private static final int INT_COSTANT_FOR_TESTING = 5;
    private static final int LONG_COSTANT_FOR_TESTING = 5;
    private World world;

    /**
     * Inizializza world prima di ogni test.
     */
    @BeforeEach
    private void createWorld() {
        this.world = new WorldImpl();
    }

    @Test
    void testSettingAndRetriavalOfClasses() {
        final LevelsManager levelsManager = new LevelsManager(INT_COSTANT_FOR_TESTING);
        final Level level = new LevelImpl(INT_COSTANT_FOR_TESTING, INT_COSTANT_FOR_TESTING,
                LONG_COSTANT_FOR_TESTING, LONG_COSTANT_FOR_TESTING, LONG_COSTANT_FOR_TESTING, LONG_COSTANT_FOR_TESTING);
        this.world.setLevelsManager(levelsManager);
        assertNotNull(this.world.getLevelsManager());
        assertEquals(levelsManager, this.world.getLevelsManager());
        this.world.setLevel(level);
        assertNotNull(this.world.getLevel());
        assertEquals(level, this.world.getLevel());
        final Game game = new GameImpl(this.world);
        this.world.setGame(game);
        assertNotNull(this.world.getGame());
        assertEquals(game, this.world.getGame());
    }

}
