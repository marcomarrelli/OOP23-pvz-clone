import controller.api.Controller;
import controller.impl.ControllerImpl;

public class PvzStart {
    
    
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        controller.initGame();
    }

}
