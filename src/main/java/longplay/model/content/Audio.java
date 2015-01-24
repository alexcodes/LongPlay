package longplay.model.content;

import org.json.JSONException;
import org.json.JSONObject;

public class Audio implements Media, ContentConstants {
    private long id;
    private long ownerId;
    private String artist;
    private String title;
    private int duration;
    private String url;
    private int genreId;

    public Audio() {
    }

    public Audio(String json) throws JSONException {
        this(new JSONObject(json));
    }

    public Audio(JSONObject json) throws JSONException {
        id = json.getLong(ID);
        ownerId = json.getLong(OWNER_ID);
        artist = json.getString(ARTIST);
        title = json.getString(TITLE);
        duration = json.getInt(DURATION);
        url = json.getString(URL);
        if (json.has(GENRE_ID)) {
            genreId = json.getInt(GENRE_ID);
        }
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getDurationString() {
        int d = duration;
        int h = d / 3600;
        d -= h * 3600;
        int m = d / 60;
        d -= m * 60;
        return (h > 0 ? h + ":" : "") + m + ":" + (d < 10 ? "0" + d : d);
    }

    @Override
    public String getFileName() {
        return getName() + " [" + id + "]" + getExtension();
    }

    private String getName() {
        return artist + " - " + title;
    }

    private String getExtension() {
        return ".mp3";
    }

    @Override
    public String toString() {
        return getName();
    }
}
