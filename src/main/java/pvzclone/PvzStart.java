package pvzclone;

import pvzclone.controller.impl.ControllerImpl;

/**
 * Plants Vs Zombies Application's Entry Point.
 */
public final class PvzStart {

    private PvzStart() {
    }

    /**
     * Main method to start the Plants Vs Zombies application.
     * 
     * @param args the command-line arguments passed to the application (not used in
     *             this case).
     */
    public static void main(final String[] args) {
        new ControllerImpl();
    }
}
