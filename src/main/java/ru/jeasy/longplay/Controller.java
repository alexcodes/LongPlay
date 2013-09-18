package ru.jeasy.longplay;

import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import ru.jeasy.longplay.model.MassStorage;
import ru.jeasy.longplay.model.SongModel;
import ru.jeasy.longplay.view.ListItemsPanel;
import ru.jeasy.longplay.view.MainFrame;
import ru.jeasy.longplay.view.TopPanel;

public class Controller {
    private static Scene scene;
    private static ListItemsPanel listItemPanel;
    private static WebEngine webEngine;
    private static StringProperty statusStringProperty;

    public static void setScene(Scene scene) {
        if (Controller.scene == null) {
            Controller.scene = scene;
        }
    }

    public static void setListItemPanel(ListItemsPanel listView) {
        listItemPanel = listView;
    }

    public static void setWebEngine(WebEngine webEngine) {
        Controller.webEngine = webEngine;
    }

    public static void setStatusStringProperty(StringProperty status) {
        statusStringProperty = status;
    }

    public static void setPrimaryScene() {
        if (scene != null) {
            scene.setRoot(new MainFrame());
        }
    }

    public static void handleLogin() {
        if (! MassStorage.user_id.equals("")) {
            TopPanel.updateHyperlink();
            MassStorage.LOGGED_IN_PROPERTY.set(true);
            setStatusText("Logged in");
            //??
        }
    }

    public static void clearItemList() {
        if (listItemPanel != null) {
            listItemPanel.clearList();
        }
    }

    public static void addItemToList(SongModel songModel) {
        if (listItemPanel != null) {
            listItemPanel.addSongItem(songModel);
        }
    }

    public static void loadMedia(String url) {
        webEngine.load(url);
    }

    public static void setStatusText(String status) {
        statusStringProperty.setValue(status);
    }
}
