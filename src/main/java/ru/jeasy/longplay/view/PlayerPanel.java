package ru.jeasy.longplay.view;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import ru.jeasy.longplay.Controller;

public class PlayerPanel extends BorderPane {
    private static final int MIN_WIDTH = 350;
    private WebView webView;

    public PlayerPanel() {
        setMinWidth(MIN_WIDTH);
        webView = new WebView();
        Controller.setWebEngine(webView.getEngine());
        setTop(webView);
        setCenter(getCenterNode());
    }

    private Node getCenterNode() {
        BorderPane bp = new BorderPane();
        return bp;
    }
}
