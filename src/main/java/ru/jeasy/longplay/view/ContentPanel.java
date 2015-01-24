package ru.jeasy.longplay.view;

import javafx.scene.layout.BorderPane;

public class ContentPanel extends BorderPane {
    public ContentPanel() {
        setLeft(new ListItemsPanel());
        setCenter(new PlayerPanel());
//        getChildren().addAll(new ListItemsPanel(), new PlayerPanel());
        setId("content-panel");
    }
}
