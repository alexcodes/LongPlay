package longplay;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import longplay.model.general.LoginState;

public class Controller {
    private static Stage mainStage;
    public static final ObjectProperty<LoginState> loginStateProperty = new SimpleObjectProperty<>(LoginState.NOT_LOGGED_IN);

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static void exit() {
        mainStage.close();
    }

    public static void showRoot() {
        try {
            replaceSceneContent("view/Root.fxml", mainStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showLoginStage() {
        showModalWindow("view/LoginStage.fxml", "Login");
    }

    private static void showModalWindow(String fxml, String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            replaceSceneContent(fxml, stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void replaceSceneContent(String fxml, Stage stage) throws Exception {
        Pane pane = FXMLLoader.load(Main.class.getResource(fxml));
        Scene scene = new Scene(pane);
        String css = Main.class.getResource("view/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
    }
}
