package ru.jeasy.longplay.model;

import ru.jeasy.longplay.Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader extends Thread {
    private SongModel songModel;

    public Downloader(SongModel songModel) {
        this.songModel = songModel;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(songModel.getURL());
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            String fileName = songModel.getArtist() + " - " + songModel.getTitle() + ".mp3";
            FileOutputStream fos = new FileOutputStream(fileName);
            Controller.setStatusText(fileName + " loading...");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            Controller.setStatusText(fileName + " loaded");
        } catch (MalformedURLException e) {
            e.printStackTrace(); //url
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
