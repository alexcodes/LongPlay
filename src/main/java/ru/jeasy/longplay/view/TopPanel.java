package ru.jeasy.longplay.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import org.json.JSONException;
import ru.jeasy.longplay.model.HttpRequest;
import ru.jeasy.longplay.model.MassStorage;
import ru.jeasy.longplay.model.ResponseParser;

import java.io.IOException;

public class TopPanel extends BorderPane {
    public static final String LOG_IN = "Log in";

    public TopPanel() {
        setLeft(new SearchPanel());
        setRight(getLink());
        setId("top-panel");
    }

    private Node getLink() {
        Hyperlink link = new Hyperlink();
        link.textProperty().bind(MassStorage.USER_NAME_PROPERTY);
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new LoginStage().show();
            }
        });
        BorderPane bp = new BorderPane();
        bp.setCenter(link);
        return bp;
    }

    public static void updateHyperlink() {
        try {
            String response = HttpRequest.loadPage(MassStorage.getURLOwner());
            ResponseParser responseParser = new ResponseParser(response);
            MassStorage.USER_NAME_PROPERTY.set(responseParser.getValue(0, ResponseParser.first_name) + " "
                    + responseParser.getValue(0, ResponseParser.last_name));
        } catch (IOException e) {
            e.printStackTrace(); //cannot load page
        } catch (JSONException e) {
            e.printStackTrace(); //cannot parse json or error
        }
    }
}
