package ru.jeasy.longplay.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import ru.jeasy.longplay.model.Downloader;
import ru.jeasy.longplay.model.SongModel;

import java.io.IOException;

public class DownloadContextMenu extends ContextMenu {
    private static DownloadContextMenu downloadContextMenu = new DownloadContextMenu();
    private static MenuItem menuItemDownload;

    public DownloadContextMenu() {
        MenuItem menuItemDownload = new MenuItem("Download...");
        DownloadContextMenu.menuItemDownload = menuItemDownload;
        getItems().add(menuItemDownload);
    }

    private static void loadAndSave(SongModel songModel) throws IOException {
        new Downloader(songModel).start();
    }

    public static DownloadContextMenu getDownloadContextMenu(final SongModel songModel) {
        menuItemDownload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    loadAndSave(songModel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return downloadContextMenu;
    }
}
