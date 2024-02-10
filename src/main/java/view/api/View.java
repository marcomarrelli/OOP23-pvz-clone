package view.api;

import javafx.scene.Scene;

/**
 * View Interface, gets/sets the current Scene and updates it.
 */
public interface View {
    /**
     * Sets the current scene to the stage.
     * 
     * @param scene The scene to load.
     */
    void setScene(Scene scene);
    
    /**
     * Gets the current scene
     * 
     * @return The currently loaded scene.
     */
    Scene getScene();

    /**
     * Updates the current scene.
     * 
     * @param scene
     */
    void update(Scene scene);
}
