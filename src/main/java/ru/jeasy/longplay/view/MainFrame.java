package ru.jeasy.longplay.view;

import javafx.scene.layout.BorderPane;

public class MainFrame extends BorderPane {
    public MainFrame() {
        setTop(new TopPanel());
        setCenter(new ContentPanel());
        setBottom(new StatusPanel());
    }
}
