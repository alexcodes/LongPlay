package ru.jeasy.longplay.model;

public class SongModel {
    private static final int MAX_STRING_LENGTH = 30;
    private String url;
    private String artist;
    private String title;
    private String duration;

    public SongModel(String url, String artist, String title, String duration) {
        this.url = url;
        this.artist = artist;
        this.title = title;
        this.duration = duration;
    }

    public String getURL() {
        return url;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getFullDescription() {
        return artist + " - " + title + " | " + convertDuration(duration);
    }

    public String toString() {
        String temp = artist + " - " + title;
        if (temp.length() > MAX_STRING_LENGTH) {
            temp = temp.substring(0, MAX_STRING_LENGTH - 1);
        }
        temp += " " + convertDuration(duration);
        return temp;
    }

    private String convertDuration(String d) {
        int dur = Integer.parseInt(d);
        String min = Integer.toString(dur / 60);
        String sec = Integer.toString(dur % 60);
        if (sec.length() == 1) {
            sec = "0" + sec;
        }
        return min + ":" + sec;
    }
}
