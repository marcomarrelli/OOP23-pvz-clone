package view.impl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.api.View;

public class ViewImpl extends Application implements View {
    private final Double APPLICATION_WIDTH = 800.0;
    private final Double APPLICATION_HEIGHT = 600.0;

    private final String APPLICATION_TITLE = "Plants Vs Zombies";
    private final boolean IS_APPLICATION_RESIZABLE = false;
    
    private final KeyCombination EXIT_FULLSCREEN_KEY_COMBINATION = KeyCombination.valueOf("ESC");
    private final String EXIT_FULLSCREEN_MESSAGE = "Press " + EXIT_FULLSCREEN_KEY_COMBINATION + " to exit Fullscreen Mode!";

    private final Scene INITIAL_SCENE = new Scene(new BorderPane());

    private final Stage APPLICATION_STAGE;
    
    private Scene currentScene;

    public ViewImpl() {
        this.APPLICATION_STAGE = new Stage();

        this.APPLICATION_STAGE.setTitle(this.APPLICATION_TITLE);
        this.APPLICATION_STAGE.setResizable(this.IS_APPLICATION_RESIZABLE);
        this.APPLICATION_STAGE.setWidth(this.APPLICATION_WIDTH);
        this.APPLICATION_STAGE.setHeight(this.APPLICATION_HEIGHT);
        this.APPLICATION_STAGE.setFullScreenExitKeyCombination(this.EXIT_FULLSCREEN_KEY_COMBINATION);
        this.APPLICATION_STAGE.setFullScreenExitHint(this.EXIT_FULLSCREEN_MESSAGE);

        this.setScene(this.INITIAL_SCENE);

        this.APPLICATION_STAGE.show();
    }

    @Override
    public void setScene(Scene scene) {
        this.currentScene = scene;
        this.APPLICATION_STAGE.setScene(this.currentScene);
    }

    @Override
    public Scene getScene() {
        throw new UnsupportedOperationException("Unimplemented method 'getScene'");
    }

    @Override
    public void update(Scene scene) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage = this.APPLICATION_STAGE;
    }
}
