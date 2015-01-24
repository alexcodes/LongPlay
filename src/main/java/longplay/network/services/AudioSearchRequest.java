package longplay.network.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import longplay.model.api.API;
import longplay.model.content.AudioResponse;

public class AudioSearchRequest extends Service<AudioResponse> {
    private String url;

    public AudioSearchRequest(String url) {
        this.url = url;
    }

    @Override
    protected Task<AudioResponse> createTask() {
        return new Task<AudioResponse>() {
            @Override
            protected AudioResponse call() throws Exception {
                return API.getAudios(url);
            }
        };
    }
}
