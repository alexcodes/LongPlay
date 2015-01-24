package longplay.model.api;

public abstract class URLBuilder implements APIConstants {
    protected StringBuilder sb;

    public URLBuilder() {
        sb = new StringBuilder();
    }

    protected void addParameter(String key) {
        String value = System.getProperty(key);
        if (value != null) {
            addParameter(key, value);
        }
    }

    protected void addParameter(String key, String value) {
        sb.append("&").append(key).append("=").append(value);
    }

    protected void addVersionApi() {
        addParameter(VERSION);
    }

    protected void addToken() {
        addParameter(ACCESS_TOKEN);
    }

    protected abstract void addEnding();

    public String build() {
        addEnding();
        return sb.toString();
    }
}
