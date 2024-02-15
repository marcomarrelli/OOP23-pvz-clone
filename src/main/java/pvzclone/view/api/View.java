package pvzclone.view.api;

import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pvzclone.controller.api.Controller;
import pvzclone.model.impl.Pair;

/**
 * View Interface, gets/sets the current Scene and updates it.
 */
public interface View {
    /**
     * Sets the current scene to the stage.
     * 
     * @param scene The scene name to load.
     */
    void setScene(String scene);

    /**
     * Gets the current scene.
     * 
     * @return The currently loaded scene.
     */
    JPanel getScene();

    /**
     * Gets the current scene.
     * 
     * @return The currently loaded scene constraint.
     */
    String getSceneConstraint();

    /**
     * Updates the current scene.
     */
    void update();

    /**
     * Returns the controller associated with the view.
     * 
     * @return the controller associated with the view.
     */
    Controller getController();

    /**
     * Returns the frame used in the view.
     * 
     * @return the frame of the view.
     */
    JFrame getFrame();

    /**
     * The End Game handler.
     * 
     * @param win if the player won or lose.
     */
    void endGame(Optional<Boolean> win);

    /**
     * Returns the scaled X and Y relative to their
     * original dimensions. If the window dimension was
     * not modified, their value should be both 1.
     * 
     * @return a pair of the scaled dimensions
     */
    Pair<Double, Double> getScale();
}
