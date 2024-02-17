package pvzclone.model.impl;

import pvzclone.model.api.Game;
import pvzclone.model.api.Level;
import pvzclone.model.api.World;

/**
 * Implementation of the World Interface.
 */
public final class WorldImpl implements World {

    private Level level;
    private Game game;
    private LevelsManager levelManager;

    @Override
    public void setLevel(final Level level) {
        this.level = level;
    }

    @Override
    public void setGame(final Game game) {
        this.game = game;
    }

    @Override
    public void setLevelsManager(final LevelsManager levelManager) {
        this.levelManager = levelManager;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public Game getGame() {
        return this.game;
    }

    @Override
    public LevelsManager getLevelsManager() {
        return this.levelManager;
    }
}
