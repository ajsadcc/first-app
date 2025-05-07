package me.ajsa.resource;

import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.ajsa.exception.ArtException;
import me.ajsa.model.Art;
import me.ajsa.model.client.ArtTimeMetrics;

@Path("/art/")
public class ArtResource {

    @Inject
    private ArtRepository artRepository;

    @RestClient
    private ArtTimeMetrics timeClient;

    @ConfigProperty(name = "greeting.message")
    String message;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addArt")
    public Response createArt(Art art) {
        Art a = artRepository.createArt(art);
        return Response.ok().entity(a).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllArts")
    public Response getAllArts() {
        List<Art> arts = artRepository.getAllArts();
        return Response.ok().entity(arts).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getArtsByName")
    public Response getArtsByName(@QueryParam(value = "name") String name) {
        List<Art> arts;
        try {
            arts = artRepository.getArtsByName(name);
        } catch (ArtException e) {
            return Response.ok().entity(e.getMessage()).build();
        }
        return Response.ok().entity(arts).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTime")
    public Response getTime(@QueryParam(value = "timeZone") String timeZone) {
        ArtTimeMetrics time = timeClient.getTime(timeZone);
        return Response.ok().entity(time).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createArtArtist")
    public Response createArtArtist(ArtArtist a) {
        ArtArtist artArtist = artRepository.createArtArtist(a);
        return Response.ok().entity(artArtist).build();
    }
}