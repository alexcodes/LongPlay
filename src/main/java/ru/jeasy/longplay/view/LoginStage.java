package ru.jeasy.longplay.view;

import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.jeasy.longplay.model.LoginModel;
import ru.jeasy.longplay.model.MassStorage;

public class LoginStage extends Stage {
    private static final int DEFAULT_WIDTH = 433;   //597
    private static final int DEFAULT_HEIGHT = 326;  //304

    public LoginStage() {
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        initStage();
        setTitle("Log in");
    }

    private void initStage() {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        new LoginModel(this, webEngine.documentProperty());
        webEngine.load(MassStorage.getURLAuth());

        ProgressIndicator progressIndicator = new ProgressIndicator();
        progressIndicator.setMaxSize(50, 50);
        progressIndicator.visibleProperty().bind(webEngine.getLoadWorker().runningProperty());

        StackPane sp = new StackPane();
        sp.getChildren().addAll(webView, progressIndicator);

        Scene scene = new Scene(sp, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setScene(scene);
    }
}
