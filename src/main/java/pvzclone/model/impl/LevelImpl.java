package pvzclone.model.impl;

import pvzclone.model.api.Level;
import pvzclone.model.api.World;

/**
 * Class that implements a Level.
 * 
 * @author Sofia Lotti.
 */
public final class LevelImpl implements Level {

    private static final int TOTAL_ZOMBIES = 5;
    private final World world;

    /**
     * Constructor of LevelImpl.
     * 
     * @param world World created by ControllerImpl.
     */
    public LevelImpl(final World world) {
        this.world = world;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public int getZombieCount() {
        return TOTAL_ZOMBIES;
    }

}
