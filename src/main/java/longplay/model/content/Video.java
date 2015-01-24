package longplay.model.content;

import longplay.network.Request;
import org.json.JSONException;
import org.json.JSONObject;

public class Video implements Media, ContentConstants {
    private long id;
    private long ownerId;
    private String title;
    private int duration;
    private String description;
    private long date;
    private int views;
    private int comments;
    private String urlPhoto130;
    private String url240;
    private String urlPlayer;

    public Video(String json) throws JSONException {
        this(new JSONObject(json));
    }

    public Video(JSONObject json) throws JSONException {
        id = json.getLong(ID);
        ownerId = json.getLong(OWNER_ID);
        title = json.getString(TITLE);
        duration = json.getInt(DURATION);
        description = json.getString(DESCRIPTION);
        date = json.getInt(DATE);
        views = json.getInt(VIEWS);
        comments = json.getInt(COMMENTS);
        urlPhoto130 = json.getString(PHOTO_130);
        urlPlayer = json.getString(PLAYER);
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public long getDate() {
        return date;
    }

    public int getViews() {
        return views;
    }

    public int getComments() {
        return comments;
    }

    public String getUrlPhoto130() {
        return urlPhoto130;
    }

    public String getUrl240() {
        return getUrl();
    }

    public String getUrlPlayer() {
        return urlPlayer;
    }

    @Override
    public String getFileName() {
        return title + "[" + id + "].mp4";
    }

    @Override
    public String getUrl() {
        if (url240 != null && ! url240.isEmpty()) {
            return url240;
        }
        String page = Request.loadPage(urlPlayer);
        String[] lines = page.split("\n");
        for (String line : lines) {
            if (line.contains("flashvars") && line.contains("<param")) {
                url240 = extractUrl(line);
                return url240;
            }
        }
        return null;
    }

    private String extractUrl(String line) {
        String[] parts = line.split("&amp;");
        for (String part : parts) {
            if (part.startsWith(URL240)) {
                return part.split("=")[1];
            }
        }
        return null;
    }

    public String toString() {
        return title;
    }
}
