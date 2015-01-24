package ru.jeasy.longplay.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ru.jeasy.longplay.view.TopPanel;

public class MassStorage {
    public static String token = "";
    public static String user_id = "";    //179583505
    public static final StringProperty USER_NAME_PROPERTY = new SimpleStringProperty(TopPanel.LOG_IN);
    public static final BooleanProperty LOGGED_IN_PROPERTY = new SimpleBooleanProperty(false);

    private static final String AUTH = "https://oauth.vk.com/authorize?";
    private static final String METHOD = "https://api.vk.com/method/";
    private static final String client_id = "3293362";
    private static final String scope = "friends,photos,audio,video,status,messages";
    private static final String redirect_uri = "https://oauth.vk.com/blank.html";
    private static final String display = "mobile";
    private static final String version = "5.0";
    private static final String response_type = "token";

    public static String getURLAuth() {
        return AUTH +
                "client_id=" + client_id +
                "&scope=" + scope +
                "&redirect_uri=" + redirect_uri +
                "&display=" + display +
                "&v=" + version +
                "&response_type=" + response_type;
    }

    public static String getURLOwner() {
        return METHOD +
                "users.get?" +
                "user_ids=" + user_id +
                "&access_token=" + token;
    }

    public static String getURLAudio(String query) {
        return METHOD +
                "audio.search?" +
                "q=" + "\"" + query + "\"" +
                "&count=100" +
                "&access_token=" + token;
    }
}
