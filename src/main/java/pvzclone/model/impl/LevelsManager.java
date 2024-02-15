package pvzclone.model.impl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class LevelsManager {
    private final static int MIN_LEVELS = 1;
    private final static int MAX_LEVELS = 5;

    private final List<LevelImpl> levelList;

    private static final int ZOMBIE_COUNT = 5;
    private static final int ZOMBIE_COUNT_STEP = 4;
    private static final long SUN_SPAWN_RATE = 3000;
    private static final long SUN_SPAWN_RATE_STEP = 120;
    private static final long ZOMBIE_SPAWN_RATE = 13_000;
    private static final long ZOMBIE_SPAWN_RATE_STEP = -300;
    private static final long SUN_SPAWN_RATE_DECREMENT_RANGE = 25;
    private static final long ZOMBIE_SPAWN_RATE_DECREMENT_RANGE = 75;

    public LevelsManager(int levelNumber) {
        this.levelList = new ArrayList<>();

        if (levelNumber < MIN_LEVELS ) {
            levelNumber = MIN_LEVELS;
        }
        else if (levelNumber > MAX_LEVELS) {
            levelNumber = MAX_LEVELS;
        }

        for (int l=0; l<levelNumber; l++) {
            this.levelList.add(this.createLevel(l));
        }
    }

    public int getLevelCount() {
        return this.levelList.size();
    }

    public LevelImpl createLevel(int delta) {
        return new LevelImpl(
            LevelsManager.ZOMBIE_COUNT +
            (LevelsManager.ZOMBIE_COUNT_STEP * delta),
            
            (LevelsManager.ZOMBIE_COUNT +
            (LevelsManager.ZOMBIE_COUNT_STEP * delta))
            / LevelsManager.ZOMBIE_COUNT,
            
            LevelsManager.SUN_SPAWN_RATE +
            (LevelsManager.SUN_SPAWN_RATE_STEP * delta),
                        
            LevelsManager.ZOMBIE_SPAWN_RATE +
            (LevelsManager.ZOMBIE_SPAWN_RATE_STEP * delta),
            
            LevelsManager.SUN_SPAWN_RATE_DECREMENT_RANGE +
            (LevelsManager.SUN_SPAWN_RATE_DECREMENT_RANGE * delta),

            LevelsManager.ZOMBIE_SPAWN_RATE_DECREMENT_RANGE +
            (LevelsManager.ZOMBIE_SPAWN_RATE_DECREMENT_RANGE * delta)
        );
    }

    public LevelImpl getLevel(Optional<Integer> index) {
        if (index.isEmpty()) {
            throw new IllegalStateException("No valid level selected!");
        }

        if (index.get() >= this.getLevelCount()) {
            return this.getLevel(Optional.of(this.getLevelCount()-1));
        }
        else if (index.get() < 0) {
            return this.getLevel(Optional.of(0));
        }
        return this.levelList.get(index.get());
    }

    public List<LevelImpl> getLevelList() {
        if (this.levelList == null || this.levelList.isEmpty()) {
            throw new IllegalStateException("There are no valid levels to load!");
        }

        return this.levelList;
    }
}
