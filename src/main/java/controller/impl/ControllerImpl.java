package controller.impl;

import controller.api.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.util.Pair;
import model.api.Game;
import model.api.WorldEvent;
import model.impl.GameImpl;
import view.impl.ViewImpl;

public class ControllerImpl implements Controller {
    
    private static final long PERIOD = 20;
    private Game game;
    //private ViewImpl view = new ViewImpl();
    //private Scene scene;

    @Override
    public void initGame() {
        // this.view = new ViewImpl();
        // Application.launch(view.getClass(), "");
        Application.launch(ViewImpl.class);
        this.game = new GameImpl();
    }

    @Override
    public void mainLoop() {
        long startTime = System.currentTimeMillis();
        while (game.isOver()) {
            long currentStartTime = System.currentTimeMillis();
            game.update();
            // view.update(this.scene);

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
