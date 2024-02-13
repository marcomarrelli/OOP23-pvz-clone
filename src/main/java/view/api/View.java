package view.api;

import javax.swing.JPanel;

import controller.api.Controller;

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
     * 
     * @return the controller associated with the view.
     */
    Controller getController();
}
