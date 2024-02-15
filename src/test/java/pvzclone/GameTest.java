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

    private World world;
    private Game game;

    @BeforeEach
    void setUp() {
        world = new WorldImpl();
        world.setLevel(new LevelImpl());
        game = new GameImpl(world);
        
    }

    @Test
    void correctCreateEntity() {
        game.createPlant(new Pair<Integer,Integer>(0, 0));
        assertEquals(1, game.getEntities().size());
    }
}
