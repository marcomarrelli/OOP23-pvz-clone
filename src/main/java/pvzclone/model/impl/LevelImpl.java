package pvzclone.model.impl;

import pvzclone.model.api.Level;

/**
 * Class that implements a Level.
 * 
 * @author Sofia Lotti.
 */
public final class LevelImpl implements Level {

    private static final int TOTAL_ZOMBIES = 5;

    @Override
    public int getZombieCount() {
        return TOTAL_ZOMBIES;
    }

}
