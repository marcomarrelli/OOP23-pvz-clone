package controller.impl;

import controller.api.Controller;
import input.api.MouseEvent;
import javafx.application.Application;
import model.api.WorldEvent;
import view.impl.ViewImpl;

public class ControllerImpl implements Controller {

    @Override
    public void initGame() {
        Application.launch(ViewImpl.class);
    }

    @Override
    public void mainLoop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mainLoop'");
    }

    @Override
    public void notifyMouseEvent(MouseEvent me) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyMouseEvent'");
    }

    @Override
    public void notifyWorldEvent(WorldEvent ev) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyEvent'");
    }
    
}
