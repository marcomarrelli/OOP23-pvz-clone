package controller.api;

import model.api.WorldEvent;

public interface Controller {

    void initGame();

    void mainLoop();

    void notifyEvent(WorldEvent ev);

}
