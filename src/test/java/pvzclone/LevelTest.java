package pvzclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.LevelsManager;

public class LevelTest {
    private final static int BELOW_MIN_LEVEL = -1;
    private final static int ABOVE_MAX_LEVEL = 999;
    private final static int CORRECT_LEVEL = 3;

    private LevelsManager newLevelsManager(final int level) {
        return new LevelsManager(level);
    }

    @Test
    void checkLevelGenerationLimits() {
        final LevelsManager correctLevelManager = newLevelsManager(CORRECT_LEVEL);
        final LevelsManager belowLimitLevelManager = newLevelsManager(BELOW_MIN_LEVEL);
        final LevelsManager aboveLimitLevelManager = newLevelsManager(ABOVE_MAX_LEVEL);

        assertEquals(correctLevelManager.getLevelCount(), CORRECT_LEVEL);

        assertNotEquals(belowLimitLevelManager.getLevelCount(), BELOW_MIN_LEVEL);
        assertNotEquals(aboveLimitLevelManager.getLevelCount(), ABOVE_MAX_LEVEL);
    }

    @Test
    void checkCreatedLevel() {
        final LevelsManager correctLevelManager = newLevelsManager(CORRECT_LEVEL);

        assertEquals(correctLevelManager.createLevel(0).getClass(), LevelImpl.class);

        assertThrowsExactly(IllegalArgumentException.class, () -> correctLevelManager.createLevel(-1));
    }

    @Test
    void checkLevelGetter() {
        final LevelsManager correctLevelManager = newLevelsManager(CORRECT_LEVEL);

        assertEquals(correctLevelManager.getLevel(Optional.of(BELOW_MIN_LEVEL)), correctLevelManager.getLevelList().get(0));
        assertEquals(correctLevelManager.getLevel(Optional.of(ABOVE_MAX_LEVEL)), correctLevelManager.getLevelList().get(CORRECT_LEVEL-1));

        assertEquals(correctLevelManager.getLevel(Optional.of(1)), correctLevelManager.getLevelList().get(1));

        assertThrowsExactly(IllegalStateException.class, () -> correctLevelManager.getLevel(Optional.empty()));
    }

    @Test
    void checkLevelListGetter() {
        final LevelsManager correctLevelManager = newLevelsManager(CORRECT_LEVEL);

        assertFalse(correctLevelManager.getLevelList().isEmpty());

        assertEquals(correctLevelManager.getLevelList().size(), correctLevelManager.getLevelCount());
        assertEquals(correctLevelManager.getLevelList().getClass(), ArrayList.class);
    }
}
