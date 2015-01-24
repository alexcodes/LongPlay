package ru.jeasy.longplay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.jeasy.longplay.Controller;

import java.net.URL;

public class Main extends Application {
    public static final int DEFAULT_WIDTH = 607;
    public static final int DEFAULT_HEIGHT = 600;
    public static final String APP_NAME = "Long Play";

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(APP_NAME);
        Scene scene = new Scene(new BorderPane(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
        scene.getStylesheets().add(getStylesheet().toString());
        stage.setScene(scene);
        Controller.setScene(scene);
        Controller.setPrimaryScene();
        stage.show();
    }

    private URL getStylesheet() {
        return getClass().getResource("/styles/style.css");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
