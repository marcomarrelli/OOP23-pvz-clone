package pvzclone.controller.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import pvzclone.controller.api.Controller;
import pvzclone.model.api.Entities;
import pvzclone.model.api.Game;
import pvzclone.model.api.World;
import pvzclone.model.impl.GameImpl;
import pvzclone.model.impl.LevelsManager;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.WorldImpl;
import pvzclone.view.api.View;
import pvzclone.view.impl.SwingViewImpl;

/**
 * Class that implements Controller.
 */
public final class ControllerImpl implements Controller {

    private static final long PERIOD = 60;
    private static final int LEVEL_COUNT = 10;
    
    private World world;
    private View view;
    private Game game;
    private Optional<Integer> chosenLevel;

    @Override
    public void initGame() {
        this.world = new WorldImpl();
        this.world.setLevelManager(new LevelsManager(LEVEL_COUNT));
        
        this.view = new SwingViewImpl(this);
        this.chosenLevel = Optional.empty();
    }

    @Override
    public void callMainloop() {
        if (this.world == null || this.view == null) {
            initGame();
        }
        new Thread(this::mainLoop).start();
    }

    private void mainLoop() {
        if (this.world == null || this.view == null) {
            return;
        }
        this.world.setLevel(this.world.getLevelManager().getLevel(chosenLevel));
        this.game = new GameImpl(this.world);
        this.world.setGame(game);
        long startTime = System.currentTimeMillis();
        while (!this.game.isOver()) {
            final long currentStartTime = System.currentTimeMillis();
            final long elapsed = currentStartTime - startTime;
            this.game.update(elapsed);
            this.view.update();
            waitForNextFrame(currentStartTime);
            startTime = currentStartTime - startTime;
        }

        this.view.endGame(this.game.getGameState().getWinState());
    }

    private void waitForNextFrame(final long currentStartTime) {
        final long dt = System.currentTimeMillis() - currentStartTime;
        if (dt < PERIOD) {
            try {
                Thread.sleep(PERIOD - dt);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void notifyMouseEvent(final Pair<Integer, Integer> clickPos) {
        this.game.mouseEvent(clickPos);
    }

    @Override
    public Set<Entities> getEntities() {
        if (this.game == null) {
            return new HashSet<Entities>();
        }

        return this.game.getEntities();
    }

    @Override
    public void newPlant(final Pair<Integer, Integer> pos) {
        game.createPlant(pos);
    }

    @Override
    public void increaseSunPoints() {
        game.getGameState().incSunScore();
    }

    @Override
    public int getSunScore() {
        return game == null ? 0 : game.getGameState().getSunScore();
    }

    @Override
    public void chooseLevel(final int numberOfTheLevel) {
        this.chosenLevel = Optional.of(numberOfTheLevel);
    }

    @Override
    public Optional<Integer> getChosenLevel() {
        return this.chosenLevel;
    }

    @Override
    public int getLevelCount() {
        if (this.world.getLevelManager() == null) {
            throw new IllegalStateException("There are no valid levels to load!");
        }

        return this.world.getLevelManager().getLevelCount();
    }
}
