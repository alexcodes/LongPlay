package longplay.model.api;

import longplay.model.content.AudioResponse;
import longplay.model.content.User;
import longplay.model.content.VideoResponse;
import longplay.network.Request;
import org.json.JSONException;

public class API {
    public static User getUser() throws JSONException {
        String json = Request.loadPage(URLProvider.getUserURL());
        return new User(json);
    }

    public static AudioResponse getAudios(String url) throws JSONException {
        String json = Request.loadPage(url);
        return new AudioResponse(json);
    }

    public static VideoResponse getVideos(String url) throws JSONException {
        String json = Request.loadPage(url);
        return new VideoResponse(json);
    }
}
