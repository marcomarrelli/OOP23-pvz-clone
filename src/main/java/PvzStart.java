import controller.api.Controller;
import controller.impl.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import view.impl.ViewImpl;

public class PvzStart {
    
    
    public static void main(String[] args) {
        //Application.launch(ViewImpl.class, "");
        ControllerImpl controller = new ControllerImpl();
        controller.initGame();
    }

}
