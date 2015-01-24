package longplay.network.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;

public class ImageLoaderService extends Service<Image> {
    private String url;

    public ImageLoaderService(String url) {
        this.url = url;
    }

    @Override
    protected Task<Image> createTask() {
        return new Task<Image>() {
            @Override
            protected Image call() throws Exception {
                return new Image(url);
            }
        };
    }
}
