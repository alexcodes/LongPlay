package longplay.model.content;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioResponse implements ContentConstants {
    private ObservableList<Audio> audios = FXCollections.observableArrayList();
    private int count;

    public AudioResponse(String json) throws JSONException {
        JSONObject response = new JSONObject(json);
        response = response.getJSONObject(RESPONSE);
        count = response.getInt(COUNT);
        JSONArray items = response.getJSONArray(ITEMS);
        for (int i = 0; i < items.length(); i++) {
            Audio audio = new Audio(items.getJSONObject(i));
            audios.add(audio);
        }
    }

    public ObservableList<Audio> getAudios() {
        return audios;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Audio audio : audios) {
            sb.append(audio.toString()).append("\n");
        }
        return sb.toString();
    }
}
