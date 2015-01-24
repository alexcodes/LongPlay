package longplay.model.content;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoResponse implements ContentConstants {
    private ObservableList<Video> videos = FXCollections.observableArrayList();
    private int count;

    public VideoResponse(String json) throws JSONException {
        JSONObject response = new JSONObject(json);
        response = response.getJSONObject(RESPONSE);
        count = response.getInt(COUNT);
        JSONArray items = response.getJSONArray(ITEMS);
        for (int i = 0; i < items.length(); i++) {
            Video video = new Video(items.getJSONObject(i));
            videos.add(video);
        }
    }

    public ObservableList<Video> getVideos() {
        return videos;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Video video : videos) {
            sb.append(video.toString()).append("\n");
        }
        return sb.toString();
    }
}
