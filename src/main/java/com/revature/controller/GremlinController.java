package com.revature.controller;

import com.revature.service.GremlinService;
import com.revature.model.Gremlin;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;

public class GremlinController {

    private final GremlinService gremlinService = new GremlinService();

    public Handler createNewGremlin = ctx -> {
        Gremlin newGremlin = ctx.bodyAsClass(Gremlin.class);

        try{
            ctx.json(gremlinService.createGremlin(newGremlin));
        } catch (NullPointerException e){
            ctx.status(400).result("Could not create gremlin");
        }
    };

    public Handler getAllGremlins = ctx -> {

        List<Gremlin> gremlins = gremlinService.getAllGremlins();
        ctx.status(200).json(gremlins);
    };
}
