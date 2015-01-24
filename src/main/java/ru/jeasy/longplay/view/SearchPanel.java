package ru.jeasy.longplay.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.json.JSONException;
import ru.jeasy.longplay.Controller;
import ru.jeasy.longplay.model.HttpRequest;
import ru.jeasy.longplay.model.MassStorage;
import ru.jeasy.longplay.model.ResponseParser;
import ru.jeasy.longplay.model.SongModel;

import java.io.IOException;

public class SearchPanel extends BorderPane {
    public SearchPanel() {
        setCenter(getCenterNode());
    }

    private Node getCenterNode() {
        final TextField textField = new TextField();
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                search(textField.getText());
            }
        });
        textField.setPromptText("Search");
        textField.visibleProperty().bind(MassStorage.LOGGED_IN_PROPERTY);
        return textField;
    }

    private void search(String query) {
        query = processQuery(query);
        try {
            String response = HttpRequest.loadPage(MassStorage.getURLAudio(query));
            ResponseParser responseParser = new ResponseParser(response);
            if (responseParser.getLength() > 1) {
                updateSongList(responseParser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processQuery(String query) {
        query = query.trim();
        if (query.contains(" ")) {
            String[] words = query.split(" ");
            query = words[0];
            for (int i = 1; i < words.length; i++) {
                query += "_" + words[i];
            }
        }
        return query;
    }

    private void updateSongList(ResponseParser responseParser) {
        Controller.clearItemList();
        for (int i = 1; i < responseParser.getLength(); i++) {
            try {
                SongModel songModel = new SongModel(
                        responseParser.getValue(i, ResponseParser.url),
                        responseParser.getValue(i, ResponseParser.artist),
                        responseParser.getValue(i, ResponseParser.title),
                        responseParser.getValue(i, ResponseParser.duration)
                );
                Controller.addItemToList(songModel);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
