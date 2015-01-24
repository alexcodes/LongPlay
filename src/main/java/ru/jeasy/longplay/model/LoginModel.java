package ru.jeasy.longplay.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import ru.jeasy.longplay.Controller;

public class LoginModel {
    private final String key = "access_token=";
    private Stage loginStage;

    public LoginModel(Stage loginStage, ReadOnlyObjectProperty<Document> docProperty) {
        this.loginStage = loginStage;
        ObjectProperty<Document> documentProperty = new SimpleObjectProperty<Document>();
        documentProperty.bind(docProperty);
        documentProperty.addListener(new ChangeListener<Document>() {
            @Override
            public void changed(ObservableValue<? extends Document> observableValue, Document document, Document document2) {
                checkDocumentForToken(document2);
            }
        });
    }

    private void checkDocumentForToken(Document doc) {
        if (doc != null) {
            String uri = doc.getDocumentURI();
            if (uri.contains(key)) {
                extractToken(uri);
                Controller.handleLogin();
                loginStage.close();
            }
        }
    }

    private void extractToken(String line) {
        String[] lines = line.split(key);
        line = lines[1];
        lines = line.split("&");
        MassStorage.token = lines[0];
        MassStorage.user_id = lines[2].split("=")[1];
    }
}
