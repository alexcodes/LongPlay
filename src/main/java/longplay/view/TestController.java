package longplay.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import longplay.model.api.API;
import longplay.model.content.Audio;
import longplay.model.content.AudioResponse;
import longplay.model.content.Video;
import longplay.model.content.VideoResponse;
import longplay.network.services.LoaderService;
import org.json.JSONException;

public class TestController {
    public void loadAudio() {
        try {
            System.out.print("Requesting audio...");
            AudioResponse response = API.getAudios("Арбенина+Шоколад");
            System.out.println("OK");
            Audio audio = response.getAudios().get(0);
            LoaderService service = new LoaderService(audio);
            System.out.println("Loading...");
            service.start();
            service.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    System.out.println(t1);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadVideo() {
        try {
            System.out.print("Requesting video...");
            VideoResponse response = API.getVideos("Nature");
            System.out.println("OK");
            Video video = response.getVideos().get(0);
            System.out.println("URL: " + video.getUrl());
            LoaderService service = new LoaderService(video);
            System.out.println("Loading...");
            service.start();
            service.progressProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                    System.out.println(t1);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
