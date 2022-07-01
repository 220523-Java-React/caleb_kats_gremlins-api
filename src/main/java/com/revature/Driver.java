package com.revature;

import com.revature.controller.GremlinController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Driver {

    public static void main(String[] args) {

        GremlinController gremlinController = new GremlinController();

        Javalin app = Javalin.create().start(8080);

        app.routes(() -> {
            path("gremlins", () -> {
                get(gremlinController.getAllGremlins);
                post(gremlinController.createNewGremlin);
            });
        });
    }
}
