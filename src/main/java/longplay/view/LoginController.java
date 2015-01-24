package longplay.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import longplay.Controller;
import longplay.model.general.LoginState;
import longplay.network.services.UserRequest;

public class LoginController {
    @FXML
    public Hyperlink link;

    @FXML
    public void initialize() {
        Controller.loginStateProperty.addListener(new ChangeListener<LoginState>() {
            @Override
            public void changed(ObservableValue<? extends LoginState> observableValue, LoginState loginState, LoginState t1) {
                check();
            }
        });
        check();
    }

    public void action() {
        Controller.showLoginStage();
    }

    private void check() {
        if (Controller.loginStateProperty.get() == LoginState.LOGGED_IN) {
            final UserRequest request = new UserRequest();
            request.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    link.setText(request.getValue().toString());
                }
            });
            request.setOnFailed(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent workerStateEvent) {
                    //TODO actions on fail
                }
            });
            request.start();
        } else {
            link.setText("Войти");
        }
    }
}
