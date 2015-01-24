package ru.jeasy.longplay.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    private static final String codePage = "UTF8";

    public static String loadPage(String url) throws IOException {
        String site;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), codePage));
        site = readString(bf);
        connection.disconnect();
        return site;
    }

    private static String readString(BufferedReader br) {
        StringBuilder sb = new StringBuilder();
        String line;
        String NL = System.getProperty("line.separator");
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append(NL);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
