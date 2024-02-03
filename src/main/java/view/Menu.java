package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Starting Menu.
 * Start Game, Fullscreen Option and Exit Buttons are available.
 * 
 * @author Marco Marrelli, Sofia Caberletti
 */
public class Menu extends Application {
    //private final double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();
    //private final double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();
    private double APPLICATION_WIDTH = 800;
    private double APPLICATION_HEIGHT = 600;
    private final double MARGINS = Math.min(APPLICATION_WIDTH*0.03, APPLICATION_HEIGHT*0.03);

    private final String FULLSCREEN_KEY_COMBINATION = "ESC";
    private final String FULLSCREEN_MESSAGE = "Press " + FULLSCREEN_KEY_COMBINATION + " to exit Fullscreen Mode!";
    private final String SCENE_BACKGROUND = "/images/menuBackground.jpeg";
    private final String BUTTON_BACKGROUND = "/images/tombstoneTexture.jpg";

    /**
     * Initialize the Stage, settings his bounds and properties.
     * 
     * @param stage the stage to be initialized.
     * @author Marco Marrelli
     */
    private void initStage(Stage stage) {
        stage.setTitle("Plants Vs Zombies");
        stage.setResizable(false);
        stage.setWidth(APPLICATION_WIDTH);
        stage.setHeight(APPLICATION_HEIGHT);

        stage.setFullScreenExitHint(FULLSCREEN_MESSAGE);
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf(FULLSCREEN_KEY_COMBINATION));
    }

    /**
     * Initialize the menu buttons group.
     * 
     * @param buttons menu buttons to be added.
     * @return VBox containing the menu buttons.
     * @author Marco Marrelli
     */
    private VBox initMenuButtons(Button... buttons)  {
        VBox box = new VBox(MARGINS, buttons);

        if(box.getChildren().isEmpty()) {
            return null;
        }

        //if(!Files.exists(Paths.get(SCENE_BACKGROUND))) throw new FileNotFoundException("File " + BUTTON_BACKGROUND + " was not found in your System!");

        box.getChildren().forEach(b -> {
            VBox.setVgrow(((Button) b), Priority.ALWAYS);
            ((Button) b).setStyle("-fx-background-image: url(\'" + BUTTON_BACKGROUND + "\'); -fx-text-fill: #ffffff; -fx-font-size: 2em; -fx-background-size: stretch;");
            ((Button) b).setMaxWidth(Double.MAX_VALUE);
            ((Button) b).setMaxHeight(APPLICATION_HEIGHT*0.1);
        });

        box.setPrefHeight(APPLICATION_HEIGHT);
        box.setMaxWidth(APPLICATION_WIDTH*0.5);
        box.setSpacing(APPLICATION_HEIGHT*0.05);
        box.setAlignment(Pos.CENTER);

        return box;
    }


    @Override
    public void start(Stage stage) throws Exception {
        initStage(stage);

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-image: url(\'" + SCENE_BACKGROUND + "\'); -fx-background-size: cover;");
        //if(!Files.exists(Paths.get(SCENE_BACKGROUND))) throw new FileNotFoundException("File " + SCENE_BACKGROUND + " was not found in your System!");

        Button startButton = new Button("Start Adventure");
        startButton.setOnAction(e -> {
            try {
                Parent p = FXMLLoader.load(getClass().getResource("/fxml/gameField.fxml"));
                System.out.println("hello");
                stage.setScene(new Scene(p));
                stage.show();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
        
        Button fullscreenButton = new Button("Fullscreen (Settings)");
        fullscreenButton.setOnAction(e -> stage.setFullScreen(!stage.isFullScreen()));

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        VBox menuGroup = initMenuButtons(startButton, fullscreenButton, exitButton);

        root.setCenter(menuGroup);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
