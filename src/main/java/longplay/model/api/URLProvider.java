package longplay.model.api;

public class URLProvider implements APIConstants {

    public static String getAuthURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(AUTH);
        addParameter(sb, CLIENT_ID);
        addParameter(sb, REDIRECT_URI);
        addParameter(sb, DISPLAY);
        addParameter(sb, SCOPE);
        addParameter(sb, RESPONSE_TYPE);
        return sb.toString();
    }

    public static String getUserURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(METHOD).append(USERS_GET).append("?");
        addEnding(sb);
        return sb.toString();
    }

    private static void addParameter(StringBuilder sb, String property) {
        String value = System.getProperty(property);
        if (value != null) {
            addParameter(sb, property, value);
        }
    }

    private static void addParameter(StringBuilder sb, String key, String value) {
        sb.append("&").append(key).append("=").append(value);
    }

    private static void addEnding(StringBuilder sb) {
        addVersionApi(sb);
        addToken(sb);
    }

    private static void addVersionApi(StringBuilder sb) {
        addParameter(sb, VERSION);
    }

    private static void addToken(StringBuilder sb) {
        addParameter(sb, ACCESS_TOKEN);
    }
}
