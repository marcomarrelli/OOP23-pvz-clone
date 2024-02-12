package controller.api;

import java.util.Set;

import input.api.ViewEventListener;
import model.api.Entities;
import model.api.WorldEventListener;

public interface Controller extends ViewEventListener, WorldEventListener {

    void initGame() throws Exception;

    void callMainloop();

    Set<Entities> getEntities();

}
