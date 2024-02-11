package model.impl;

import model.api.Level;
import model.api.World;

public class LevelImpl implements Level {

    private final World world;

    public LevelImpl(final World world){
        this.world = world;
    }

    @Override
    public int getZombieCount() {
        //dobbiamo legare in qualche modo GameState alle altre classi...da world possiamo arrivare a Game, ma non ha un metodo di
        //Zombie count. Quel metodo ce l'ha GameState, quindi potremmo creare un metodo getGameState nella classe Game
        return 0;    
    }
    
}
