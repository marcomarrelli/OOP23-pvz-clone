package pvzclone.model.impl;

import pvzclone.model.api.Game;
import pvzclone.model.api.Level;
import pvzclone.model.api.World;

/**
 * Implementation of the World Interface.
 * 
 * @author Sofia Caberletti
 */
public final class WorldImpl implements World {

    private Level level;
    private Game game;

    @Override
    public void setLevel(final Level level) {
        this.level = level;
    }

    @Override
    public void setGame(final Game game) {
        this.game = game;
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
