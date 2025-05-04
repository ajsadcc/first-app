package me.ajsa.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import me.ajsa.service.DjeloService;

@Path("/djela")
public class DjeloController {

    @Inject
    DjeloService djeloService;

    @POST
    @Path("/create-example")
    public Response createExample() {
        djeloService.createDjelo();
        return Response.ok("Djelo sa kritikama je uspješno sačuvano.").build();
    }
}
