package longplay.view;

import longplay.Controller;

public class TopController {

    public void minimize() {
        System.out.println("minimize");
    }

    public void maximize() {
        System.out.println("maximize");
    }

    public void close() {
        Controller.exit();
    }
}
