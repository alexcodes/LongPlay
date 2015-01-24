package longplay.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import longplay.Controller;
import longplay.model.api.APIConstants;
import longplay.model.api.URLProvider;
import longplay.model.general.LoginState;

public class LoginStageController {
    @FXML
    private WebView webView;
    @FXML
    private BorderPane progressPane;
    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    public void initialize() {
        WebEngine engine = webView.getEngine();
        progressIndicator.progressProperty().bind(engine.getLoadWorker().progressProperty());
        progressPane.visibleProperty().bind(engine.getLoadWorker().runningProperty());
        engine.load(URLProvider.getAuthURL());
        engine.locationProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println(t1);
                if (containsToken(t1)) {
                    Controller.loginStateProperty.setValue(LoginState.LOGGED_IN);
                    //close
                }
            }
        });
    }

    public boolean containsToken(String url) {
        if (url.contains(APIConstants.ACCESS_TOKEN)) {
            url = url.split("#")[1];
            String[] pairs  = url.split("&");
            for (String pair : pairs) {
                String[] words = extractParam(pair);
                if (words != null) {
                    System.setProperty(words[0], words[1]);
                }
            }
            return true;
        }
        return false;
    }

    private String[] extractParam(String pair) {
        String[] words = pair.split("=");
        if (words.length != 2) {
            return null;
        }
        String key = words[0];
        String value = words[1];
        if (key != null && value != null && ! key.isEmpty() && ! value.isEmpty()) {
            return words;
        }
        return null;
    }
}
