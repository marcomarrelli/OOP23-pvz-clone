package view;

import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Menu extends Application {
    //private final int SCREEN_WIDTH = Screen.getPrimary().getWidth();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fileLoader = new FXMLLoader(getClass().getResource("/menuBackground.fxml"));
        Parent background = fileLoader.load();

        primaryStage.setTitle("Plants Vs Zombies");
        primaryStage.setScene(new Scene(background, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
