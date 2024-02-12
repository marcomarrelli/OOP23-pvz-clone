import controller.impl.ControllerImpl;

/**
 * Plants Vs Zombies Application's Entry Point.
 * 
 * @author Sofia Caberletti, Margherita Zanchini, Sofia Lotti, Maco Marrelli
 */
public class PvzStart {    
    public static void main(String[] args) {
        ControllerImpl controller = new ControllerImpl();
        controller.initGame();
    }
}
