package pvzclone.model.impl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 * Class used for Managing Levels in the Game.
 * 
 * @author Marco Marrelli
 */
public final class LevelsManager {
    private static final int MIN_LEVELS = 1;
    private static final int MAX_LEVELS = 5;
    private static final int ZOMBIE_COUNT = 5;
    private static final int ZOMBIE_COUNT_STEP = 4;
    private static final long SUN_SPAWN_RATE = 4000;
    private static final long SUN_SPAWN_RATE_STEP = 120;
    private static final long ZOMBIE_SPAWN_RATE = 12_000;
    private static final long ZOMBIE_SPAWN_RATE_STEP = -300;
    private static final long SUN_SPAWN_RATE_DECREMENT_RANGE = 25;
    private static final long ZOMBIE_SPAWN_RATE_DECREMENT_RANGE = 75;
    private final List<LevelImpl> levelList;

    /**
     * Constructor for LevelsManager.
     * 
     * @param levelNumber number of levels to generate.
     */
    public LevelsManager(final int levelNumber) {
        int tempLevels = levelNumber;

        if (tempLevels < MIN_LEVELS) {
            tempLevels = MIN_LEVELS;
        } else if (tempLevels > MAX_LEVELS) {
            tempLevels = MAX_LEVELS;
        }

        this.levelList = new ArrayList<>();

        for (int l = 0; l < tempLevels; l++) {
            this.levelList.add(this.createLevel(l));
        }
    }

    /**
     * Returns the number of levels.
     * 
     * @return the number of levels.
     */
    public int getLevelCount() {
        return this.levelList.size();
    }

    /**
     * Returns a new created level regarding the delta.
     * 
     * @param delta the index of the level in the list.
     * @return the number of levels.
     */
    public LevelImpl createLevel(final int delta) {
        return new LevelImpl(
                LevelsManager.ZOMBIE_COUNT
                        + (LevelsManager.ZOMBIE_COUNT_STEP * delta),

                (LevelsManager.ZOMBIE_COUNT
                        + (LevelsManager.ZOMBIE_COUNT_STEP * delta))
                        / LevelsManager.ZOMBIE_COUNT,

                LevelsManager.SUN_SPAWN_RATE
                        + (LevelsManager.SUN_SPAWN_RATE_STEP * delta),

                LevelsManager.ZOMBIE_SPAWN_RATE
                        + (LevelsManager.ZOMBIE_SPAWN_RATE_STEP * delta),

                LevelsManager.SUN_SPAWN_RATE_DECREMENT_RANGE
                        + (LevelsManager.SUN_SPAWN_RATE_DECREMENT_RANGE * delta),

                LevelsManager.ZOMBIE_SPAWN_RATE_DECREMENT_RANGE
                        + (LevelsManager.ZOMBIE_SPAWN_RATE_DECREMENT_RANGE * delta));
    }

    /**
     * Returns the level at index inside the list.
     * 
     * @param index the index of the level in the list.
     * @return the level at the given index in the list.
     */
    public LevelImpl getLevel(final Optional<Integer> index) {
        if (index.isEmpty()) {
            throw new IllegalStateException("No valid level selected!");
        }

        if (index.get() >= this.getLevelCount()) {
            return this.getLevel(Optional.of(this.getLevelCount() - 1));
        } else if (index.get() < 0) {
            return this.getLevel(Optional.of(0));
        }
        return this.levelList.get(index.get());
    }

    /**
     * Returns the list of levels.
     * 
     * @return the levels list.
     */
    public List<LevelImpl> getLevelList() {
        if (this.levelList == null || this.levelList.isEmpty()) {
            throw new IllegalStateException("There are no valid levels to load!");
        }

        return this.levelList;
    }
}
