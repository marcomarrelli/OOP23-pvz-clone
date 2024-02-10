package controller.impl;

import controller.api.Controller;
import javafx.application.Application;
import javafx.util.Pair;
import model.api.Game;
import model.api.WorldEvent;
import model.impl.GameImpl;
import view.impl.ViewImpl;

public class ControllerImpl implements Controller {
    
    GameImpl game;

    @Override
    public void initGame() {
        Application.launch(ViewImpl.class);
        game = new GameImpl();
    }

    @Override
    public void mainLoop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mainLoop'");
    }

    @Override
    public void notifyMouseEvent(Pair<Double, Double> clickPos) {
        game.mouseEvent(clickPos);
    }

    @Override
    public void notifyWorldEvent(WorldEvent ev) {
        //qua ho un dubbio, se è gia il model che gestisce le collisioni interne
        //già lui controlla che ci siano state cose
        //il controller lo comunica alla view?
    }
    
}
