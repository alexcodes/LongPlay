package longplay.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import longplay.MediaController;
import longplay.model.content.Audio;

@SuppressWarnings("unchecked")
public class AudioController {
    @FXML
    public ListView listView;

    @FXML
    protected void initialize() {
        MediaController.setAudioController(this);
    }

    public void addItems(ObservableList<Audio> audios) {
        ObservableList<AudioItem> items = FXCollections.observableArrayList();
        for (Audio audio : audios) {
            items.add(new AudioItem(audio));
        }
        listView.getItems().addAll(items);
    }

    public void setItems(ObservableList<Audio> audios) {
        listView.getItems().clear();
        addItems(audios);
    }
}
