package longplay;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import longplay.model.api.APIConstants;
import longplay.model.general.LoginState;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends Application {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    private static final String PROPERTIES = "properties.properties";

    @Override
    public void init() {
        loadProperties(PROPERTIES);
        if (System.getProperty(APIConstants.ACCESS_TOKEN) != null) {
            Controller.loginStateProperty.setValue(LoginState.LOGGED_IN);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(DEFAULT_WIDTH);
        stage.setHeight(DEFAULT_HEIGHT);
        Controller.setMainStage(stage);
        Controller.showRoot();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                //storeProperties();
            }
        });
        stage.show();
    }

    private void loadProperties(String path) {
        try {
            System.getProperties().load(Main.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void storeProperties() {
        try {
            System.getProperties().store(new FileOutputStream(PROPERTIES), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
