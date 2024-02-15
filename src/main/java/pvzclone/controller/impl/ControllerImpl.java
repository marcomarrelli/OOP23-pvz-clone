package pvzclone.controller.impl;

import java.util.HashSet;
import java.util.Set;

import pvzclone.controller.api.Controller;
import pvzclone.model.api.Entities;
import pvzclone.model.api.Game;
import pvzclone.model.api.World;
import pvzclone.model.impl.GameImpl;
import pvzclone.model.impl.LevelImpl;
import pvzclone.model.impl.Pair;
import pvzclone.model.impl.WorldImpl;
import pvzclone.view.api.View;
import pvzclone.view.impl.SwingViewImpl;

/**
 * Class that implements Controller.
 */
public final class ControllerImpl implements Controller {

    private static final long PERIOD = 80;

    private World world;
    private View view;
    private Game game;

    @Override
    public void initGame() {
        this.world = new WorldImpl();
        this.view = new SwingViewImpl(this);
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
        this.world.setLevel(new LevelImpl());
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

    /*
     * @Override
     * public void notifyWorldEvent(WorldEvent ev) {
     * //qua ho un dubbio, se è gia il model che gestisce le collisioni interne
     * //già lui controlla che ci siano state cose
     * //il controller lo comunica alla view?
     * }
     */
}
