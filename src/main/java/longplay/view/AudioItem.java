package longplay.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import longplay.model.content.Audio;
import longplay.network.services.LoaderService;

public class AudioItem extends StackPane {
    private Audio audio;

    public AudioItem(Audio audio) {
        this.audio = audio;
        addContent();
    }

    private void addContent() {
        BorderPane bp = new BorderPane();
        Text name = new Text(audio.toString());
        bp.setLeft(name);
        BorderPane right = new BorderPane();
        Button button = new Button("Скачать");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoaderService loader = new LoaderService(audio);
                loader.progressProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        System.out.println(audio.getId() + " - " + newValue + "%");
                    }
                });
                loader.start();
            }
        });
        right.setLeft(button);
        Text duration = new Text(audio.getDurationString());
        right.setRight(duration);
        bp.setRight(right);
        this.getChildren().add(bp);
    }
}
