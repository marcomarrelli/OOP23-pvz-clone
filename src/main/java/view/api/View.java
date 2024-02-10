package view.api;

import javax.swing.JPanel;

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
     * Gets the current scene
     * 
     * @return The currently loaded scene.
     */
    JPanel getScene();

        /**
     * Gets the current scene
     * 
     * @return The currently loaded scene constraint.
     */
    String getSceneConstraint();

    /**
     * Updates the scene.
     * 
     * @param scene the scene to update
     */
    void update(JPanel scene);
}
