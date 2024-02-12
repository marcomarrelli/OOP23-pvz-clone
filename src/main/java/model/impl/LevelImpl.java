package model.impl;

import model.api.Level;
import model.api.World;
/**
 * Class that implements a Level
 * 
 * @author Sofia Lotti.
 */
public class LevelImpl implements Level {

    private static final int TOTAL_ZOMBIES = 20;
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
        return TOTAL_ZOMBIES;  //momentaneo, andrà cambiato in base al livello magari come abbiamo detto l'11 sera  
    }
    
}
