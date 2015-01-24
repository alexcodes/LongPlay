package longplay.model.api;

public interface APIConstants {
    //
    //General
    //
    public static final String ACCESS_TOKEN = "access_token";
    public static final String USER_ID = "user_id";
    public static final String VERSION = "v";

    //
    //Authentication
    //
    public static final String AUTH = "https://oauth.vk.com/authorize?";
    public static final String CLIENT_ID = "client_id";
    public static final String REDIRECT_URI = "redirect_uri";
    public static final String DISPLAY = "display";
    public static final String SCOPE = "scope";
    public static final String RESPONSE_TYPE = "response_type";

    //
    //Methods
    //
    public static final String METHOD = "https://api.vk.com/method/";

    //
    //USERS
    //
    public static final String USERS_GET = "users.get";

    //
    //Audio
    //
    public static final String AUDIO_SEARCH = "audio.search";
    public static final String AUTO_COMPLETE = "auto_complete";

    //
    //Video
    //
    public static final String VIDEO_SEARCH = "video.search";
    public static final String HD = "hd";
    public static final String ADULT = "adult";
    public static final String FILTERS = "filters";
    public static final String LONGER = "longer";
    public static final String SHORTER = "shorter";
    public static final String MP4 = "mp4";

    //
    //Audio+Video
    //
    public static final String QUERY = "q";
    public static final String OFFSET = "offset";
    public static final String COUNT = "count";
    public static final String SORT = "sort";
}
