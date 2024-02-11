import controller.impl.ControllerImpl;


/**
 * Application's Entry Point
 */
public class PvzStart {    
    public static void main(String[] args) {
        ControllerImpl controller = new ControllerImpl();
        controller.initGame();
        controller.mainLoop();
    }
}
