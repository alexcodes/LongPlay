package ru.jeasy.longplay.view;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import ru.jeasy.longplay.Controller;
import ru.jeasy.longplay.model.SongModel;

public class ListItemsPanel extends ListView {
    private static final int MIN_WIDTH = 250;
    private ObservableList items;

    public ListItemsPanel() {
        setMinWidth(MIN_WIDTH);
        this.items = getItems();
        Controller.setListItemPanel(this);
        //disableProperty().bind(MassStorage.LOGGED_IN_PROPERTY.not());
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleMousePress(mouseEvent);
            }
        });
    }

    public void clearList() {
        items.clear();
    }

    public void addSongItem(SongModel songModel) {
        items.add(songModel);
    }

    private void handleMousePress(MouseEvent mouseEvent) {
        MultipleSelectionModel msm = getSelectionModel();
        SongModel songModel = (SongModel) msm.getSelectedItem();
        if (songModel != null) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                try {
                    Controller.loadMedia(songModel.getURL());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                try {
                    DownloadContextMenu.getDownloadContextMenu(songModel).show(this,
                            mouseEvent.getScreenX(), mouseEvent.getScreenY());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
