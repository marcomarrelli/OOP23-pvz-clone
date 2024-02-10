package view.impl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.api.View;

public class ViewImpl extends Application implements View {
    private static final double APPLICATION_WIDTH = 800.0;
    private static final double APPLICATION_HEIGHT = 600.0;

    private static final String APPLICATION_TITLE = "Plants Vs Zombies";
    private static final boolean IS_APPLICATION_RESIZABLE = false;
    
    private static final KeyCombination EXIT_FULLSCREEN_KEY_COMBINATION = KeyCombination.valueOf("ESC");
    private static final String EXIT_FULLSCREEN_MESSAGE = "Press " + EXIT_FULLSCREEN_KEY_COMBINATION + " to exit Fullscreen Mode!";

    private static final Scene INITIAL_SCENE = new Scene(new BorderPane());

    private final Stage APPLICATION_STAGE;
    
    private Scene currentScene;

    public ViewImpl() {
        this.APPLICATION_STAGE = new Stage();

        this.APPLICATION_STAGE.setTitle(APPLICATION_TITLE);
        this.APPLICATION_STAGE.setResizable(IS_APPLICATION_RESIZABLE);
        this.APPLICATION_STAGE.setWidth(APPLICATION_WIDTH);
        this.APPLICATION_STAGE.setHeight(APPLICATION_HEIGHT);
        this.APPLICATION_STAGE.setFullScreenExitKeyCombination(EXIT_FULLSCREEN_KEY_COMBINATION);
        this.APPLICATION_STAGE.setFullScreenExitHint(EXIT_FULLSCREEN_MESSAGE);

        this.setScene(INITIAL_SCENE);

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
