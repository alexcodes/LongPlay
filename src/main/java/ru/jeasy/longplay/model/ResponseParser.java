package ru.jeasy.longplay.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResponseParser {
    private static final String response = "response";
    //person
    public static final String uid = "uid";
    public static final String first_name = "first_name";
    public static final String last_name = "last_name";
    //audio
    public static final String aid = "aid";
    public static final String owner_id = "owner_id";
    public static final String artist = "artist";
    public static final String title = "title";
    public static final String duration = "duration";
    public static final String url = "url";

    private JSONArray jsonArray;

    public ResponseParser(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            jsonArray = (JSONArray) jsonObject.get(ResponseParser.response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getValue(int index, String key) throws JSONException {
        return jsonArray.getJSONObject(index).getString(key);
    }

    public int getLength() {
        return jsonArray.length();
    }
}
