package model.impl;

import model.api.Level;
import model.api.World;
/**
 * Class that implements a Level
 * 
 * @author Sofia Lotti.
 */
public class LevelImpl implements Level {

    private final World world;
    /**
     * Constructor of LevelImpl
     * 
     * @param world World created by ControllerImpl.
     */
    public LevelImpl(final World world){
        this.world = world;
    }

    @Override
    public int getZombieCount() {
        return this.world.getGame().getGameState().getKilledZombies();    
    }
    
}
