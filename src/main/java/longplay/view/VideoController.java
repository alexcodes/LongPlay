package longplay.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import longplay.MediaController;
import longplay.model.content.Video;

@SuppressWarnings("unchecked")
public class VideoController {
    @FXML
    public ListView listView;

    @FXML
    protected void initialize() {
        MediaController.setVideoController(this);
    }

    public void addItems(ObservableList<Video> videos) {
        ObservableList<VideoItem> items = FXCollections.observableArrayList();
        for (Video video : videos) {
            items.add(new VideoItem(video));
        }
        listView.getItems().addAll(items);
    }

    public void setItems(ObservableList<Video> videos) {
        listView.getItems().clear();
        addItems(videos);
    }
}
