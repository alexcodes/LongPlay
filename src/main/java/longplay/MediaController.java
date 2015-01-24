package longplay;

import javafx.collections.ObservableList;
import longplay.model.content.Audio;
import longplay.model.content.Video;
import longplay.view.AudioController;
import longplay.view.VideoController;

public class MediaController {
    private static AudioController audioController;
    private static VideoController videoController;

    public static void setAudioController(AudioController controller) {
        audioController = controller;
    }

    public static void setVideoController(VideoController videoController) {
        MediaController.videoController = videoController;
    }

    public static void addAudios(ObservableList<Audio> audios, boolean reset) {
        if (reset) {
            audioController.setItems(audios);
        } else {
            audioController.addItems(audios);
        }
    }

    public static void addVideos(ObservableList<Video> videos, boolean reset) {
        if (reset) {
            videoController.setItems(videos);
        } else {
            videoController.addItems(videos);
        }
    }
}
