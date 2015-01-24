package longplay.model.api;

public class AudioURLBuilder extends URLBuilder implements APIConstants {

    public AudioURLBuilder() {
        super();
        sb.append(METHOD);
        sb.append(AUDIO_SEARCH).append("?");
    }

    @Override
    protected void addEnding() {
        addParameter(COUNT, Integer.toString(20));
        addVersionApi();
        addToken();
    }

    public AudioURLBuilder addQuery(String query) {
        addParameter(QUERY, query);
        return this;
    }

    public AudioURLBuilder addOffset(int offset) {
        addParameter(OFFSET, Integer.toString(offset));
        return this;
    }
}
