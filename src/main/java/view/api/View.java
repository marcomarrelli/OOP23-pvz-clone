package view.api;

import javax.swing.JPanel;

/**
 * View Interface, gets/sets the current Scene and updates it.
 */
public interface View {
    /**
     * Sets the current scene to the stage.
     * 
     * @param scene The scene to load.
     */
    void setScene(JPanel scene);
    
    /**
     * Gets the current scene
     * 
     * @return The currently loaded scene.
     */
    JPanel getScene();

    /**
     * Updates the current scene.
     * 
     * @param scene
     */
    void update(JPanel scene);
}
