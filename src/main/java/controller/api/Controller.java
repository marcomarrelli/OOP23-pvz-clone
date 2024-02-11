package controller.api;

import input.api.ViewEventListener;
import model.api.WorldEventListener;

public interface Controller extends ViewEventListener, WorldEventListener {

    void initGame() throws Exception;

    void mainLoop();

}
