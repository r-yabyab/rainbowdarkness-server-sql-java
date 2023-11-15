import Controller.MoodController;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
        MoodController controller = new MoodController();
        Javalin app = controller.startAPI();
        app.start(8080);
    }
}