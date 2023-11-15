package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

// import com.fasterxml.jackson.core.JsonProcessingException;;

public class MoodController {
    //add service objects here

    public MoodController() {
        //constructor for service objects
    }

    public Javalin startAPI() {
        Javalin app = Javalin.create();
        //CRUD operations
        app.get("/moods", this::getAllMoodHandler);
        //Login and registrations
    }
}
