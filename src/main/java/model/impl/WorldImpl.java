package model.impl;

import model.api.Game;
import model.api.Level;
import model.api.World;


/**
 * Implementation of the World Interface.
 * 
 * @author Sofia Caberletti
 */
public class WorldImpl implements World {

    private Level level;
    private Game game;

    @Override
    public void setLevel(Level level) {
        this.level= level;
    }

    @Override
    public void setGame(Game game) {
        this.game= game;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public Game getGame() {
        return this.game;
    }
    
}
