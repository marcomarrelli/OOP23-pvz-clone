package controller.impl;

import controller.api.Controller;
import model.api.Game;
import model.api.World;
import model.api.WorldEvent;
import model.impl.GameImpl;
import model.impl.Pair;
import model.impl.WorldImpl;
import view.api.View;
import view.impl.GamePanel;
import view.impl.SwingViewImpl;

public class ControllerImpl implements Controller {
    
    private static final long PERIOD = 20;

    private World world;
    private View view;
    private Game game;

    @Override
    public void initGame() {
        this.world = new WorldImpl();
        this.view = new SwingViewImpl();
        this.game = this.world.getGame();
        
        // this.game = new GameImpl();
        // this.view.setScene(SwingViewImpl.GAME_PANEL_CONSTRAINT);
    }

    @Override
    public void mainLoop() {
        long startTime = System.currentTimeMillis();
        while (this.game.isOver()) {
            long currentStartTime = System.currentTimeMillis();
            this.game.update();
        }
    }

    @Override
    public void notifyMouseEvent(Pair<Double, Double> clickPos) {
        this.game.mouseEvent(clickPos);
    }

    @Override
    public void notifyWorldEvent(WorldEvent ev) {
        //qua ho un dubbio, se è gia il model che gestisce le collisioni interne
        //già lui controlla che ci siano state cose
        //il controller lo comunica alla view?
    }
}
