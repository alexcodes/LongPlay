package longplay.view;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import longplay.model.content.Video;
import longplay.network.services.ImageLoaderService;

public class VideoItem extends BorderPane {
    private Video video;

    public VideoItem(Video video) {
        this.video = video;
        setId("video");
        setPictureSide();
        setTextSide();
    }

    private void setPictureSide() {
        Node play = getPlayNode();
        Node picture = getPictureNode();

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(picture, play);

        setLeft(stackPane);
    }

    private Node getPictureNode() {
        final ImageView view = new ImageView();
        final ImageLoaderService loaderService = new ImageLoaderService(video.getUrlPhoto130());
        loaderService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                view.setImage(loaderService.getValue());
            }
        });
        loaderService.start();
        return view;
    }

    private Node getPlayNode() {
        final double TRIANGLE_SIZE = 40.0;
        final Polygon play = new Polygon(new double[]{
                0, 0,
                0, TRIANGLE_SIZE,
                TRIANGLE_SIZE * 0.85, TRIANGLE_SIZE * 0.5
        });
        play.setFill(Color.rgb(220, 220, 220, 0.85));
        play.setOpacity(0.0);
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                play.setOpacity(1.0);
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                play.setOpacity(0.0);
            }
        });
        return play;
    }

    private void setTextSide() {
        BorderPane bp = new BorderPane();
        Text title = new Text(video.toString());
        title.setId("video-title");
        Text description = new Text(video.getDescription());
        bp.setId("video-text");
        bp.setTop(title);
        bp.setLeft(new BorderPane(description));
        setCenter(bp);
    }
}
