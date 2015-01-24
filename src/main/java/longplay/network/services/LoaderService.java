package longplay.network.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import longplay.model.content.Media;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Max speed:     ~8 Mb/s
 * Average speed: <1 Mb/s
 */
public class LoaderService extends Service<Void> {
    private static final int BUFFER_LENGTH = 1024*100;
    private Media media;

    public LoaderService(Media media) {
        this.media = media;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                URL url = new URL(media.getUrl());
                URLConnection connection = url.openConnection();
                long total = connection.getContentLengthLong();
                long bytesLoaded = 0;
                InputStream is = connection.getInputStream();
                File file = new File(media.getFileName());
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buffer = new byte[BUFFER_LENGTH];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) > 0) {
                    if (isCancelled()) {
                        break;
                    }
                    fos.write(buffer, 0, bytesRead);
                    bytesLoaded += bytesRead;
                    updateProgress(bytesLoaded, total);
                }
                is.close();
                fos.flush();
                fos.close();
                return null;
            }
        };
    }
}
