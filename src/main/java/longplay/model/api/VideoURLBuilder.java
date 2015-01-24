package longplay.model.api;

public class VideoURLBuilder extends URLBuilder implements APIConstants {

    public VideoURLBuilder() {
        super();
        sb.append(METHOD);
        sb.append(VIDEO_SEARCH).append("?");
    }

    @Override
    protected void addEnding() {
        addParameter(FILTERS, MP4);
        addParameter(COUNT, Integer.toString(20));
        addVersionApi();
        addToken();
    }

    public VideoURLBuilder addQuery(String query) {
        addParameter(QUERY, query);
        return this;
    }

    public VideoURLBuilder addOffset(int offset) {
        addParameter(OFFSET, Integer.toString(offset));
        return this;
    }

    public VideoURLBuilder addFilterLonger(String longer) {
        addParameter(LONGER, longer);
        return this;
    }

    public VideoURLBuilder addFilterShorter(String shorter) {
        addParameter(SHORTER, shorter);
        return this;
    }

    public VideoURLBuilder setSafeSearch(boolean safe) {
        String param = safe ? "0" : "1";
        addParameter(ADULT, param);
        return this;
    }
}
