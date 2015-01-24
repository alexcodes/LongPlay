package longplay.view;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import longplay.MediaController;
import longplay.model.api.AudioURLBuilder;
import longplay.model.api.VideoURLBuilder;
import longplay.network.services.AudioSearchRequest;
import longplay.network.services.VideoSearchRequest;

public class SearchController {
    @FXML
    public TextField textField;

    public void search() {
        String query = textField.getText();
        query = removeSpaces(query);
        searchVideo(query);
    }

    private void searchAudio(String query) {
        String url = new AudioURLBuilder()
                .addQuery(query)
                .build();
        final AudioSearchRequest request = new AudioSearchRequest(url);
        request.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                System.out.println(request.getValue());
                MediaController.addAudios(request.getValue().getAudios(), true);
            }
        });
        request.start();
    }

    private void searchVideo(String query) {
        String url = new VideoURLBuilder()
                .addQuery(query)
                .build();
        final VideoSearchRequest request = new VideoSearchRequest(url);
        request.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                System.out.println(request.getValue());
                MediaController.addVideos(request.getValue().getVideos(), true);
            }
        });
        request.start();
    }

    private String removeSpaces(String s) {
        return s.replace(" ", "+");
    }
}
