package pvzclone;
import pvzclone.controller.impl.ControllerImpl;

/**
 * Plants Vs Zombies Application's Entry Point.
 * 
 * @author Sofia Caberletti, Margherita Zanchini, Sofia Lotti, Marco Marrelli.
 */
public final class PvzStart {
    /**
     * Main method to start the Plants Vs Zombies application.
     * 
     * @param args the command-line arguments passed to the application (not used in
     *             this case).
     */
    public static void main(final String[] args) {
        ControllerImpl controller = new ControllerImpl();
        controller.initGame();
    }

    private PvzStart() {
        PvzStart.main(null);
    }
}
