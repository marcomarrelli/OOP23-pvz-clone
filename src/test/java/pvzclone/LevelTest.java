package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.LevelsManager;

/**
 * Level, LevelImpl and LevelsManager Tests.
 * 
 * @author Marco Marrelli
 */
class LevelTest {
    private static final int BELOW_MIN_LEVEL = -1;
    private static final int ABOVE_MAX_LEVEL = 999;
    private static final int CORRECT_LEVEL = 3;

    private final LevelsManager correctLevelManager = new LevelsManager(CORRECT_LEVEL);
    private final LevelsManager belowLimitLevelManager = new LevelsManager(BELOW_MIN_LEVEL);
    private final LevelsManager aboveLimitLevelManager = new LevelsManager(ABOVE_MAX_LEVEL);

    @Test
    void checkLevelGenerationLimits() {
        assertEquals(this.correctLevelManager.getLevelCount(), CORRECT_LEVEL);

        assertNotEquals(belowLimitLevelManager.getLevelCount(), BELOW_MIN_LEVEL);
        assertNotEquals(aboveLimitLevelManager.getLevelCount(), ABOVE_MAX_LEVEL);
    }

    @Test
    void checkCreatedLevel() {
        assertEquals(this.correctLevelManager.createLevel(0).getClass(), LevelImpl.class);

        assertThrowsExactly(IllegalArgumentException.class, () -> this.correctLevelManager.createLevel(-1));
    }

    @Test
    void checkLevelGetter() {
        assertEquals(this.correctLevelManager.getLevel(Optional.of(BELOW_MIN_LEVEL)),
                    this.correctLevelManager.getLevelList().get(0));
        assertEquals(this.correctLevelManager.getLevel(Optional.of(ABOVE_MAX_LEVEL)),
                    this.correctLevelManager.getLevelList().get(CORRECT_LEVEL - 1));

        assertEquals(this.correctLevelManager.getLevel(Optional.of(1)), this.correctLevelManager.getLevelList().get(1));

        assertThrowsExactly(IllegalStateException.class, () -> this.correctLevelManager.getLevel(Optional.empty()));
    }

    @Test
    void checkLevelListGetter() {
        assertFalse(this.correctLevelManager.getLevelList().isEmpty());

        assertEquals(this.correctLevelManager.getLevelList().size(), this.correctLevelManager.getLevelCount());
        assertEquals(this.correctLevelManager.getLevelList().getClass(), List.class);
    }
}
