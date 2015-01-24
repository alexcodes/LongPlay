package longplay.network.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import longplay.model.api.API;
import longplay.model.content.User;

public class UserRequest extends Service<User> {
    @Override
    protected Task<User> createTask() {
        return new Task<User>() {
            @Override
            protected User call() throws Exception {
                return API.getUser();
            }
        };
    }
}
