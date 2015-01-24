package longplay.network.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import longplay.model.api.API;
import longplay.model.content.VideoResponse;

public class VideoSearchRequest extends Service<VideoResponse> {
    private String url;

    public VideoSearchRequest(String url) {
        this.url = url;
    }

    @Override
    protected Task<VideoResponse> createTask() {
        return new Task<VideoResponse>() {
            @Override
            protected VideoResponse call() throws Exception {
                return API.getVideos(url);
            }
        };
    }
}
