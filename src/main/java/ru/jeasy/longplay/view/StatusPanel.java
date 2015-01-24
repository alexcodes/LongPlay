package ru.jeasy.longplay.view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import ru.jeasy.longplay.Controller;

public class StatusPanel extends HBox {
    public StatusPanel() {
        Text text = new Text("Log in, please");
        Controller.setStatusStringProperty(text.textProperty());
        getChildren().add(text);
    }
}
