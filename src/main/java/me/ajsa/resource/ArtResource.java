package me.ajsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.ajsa.exception.ArtException;
import me.ajsa.model.Art;
import me.ajsa.repository.ArtRepository;

import java.util.List;

@Path("/art/")
public class ArtResource {

    @Inject
    private ArtRepository artRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response createArt(Art art) {
        Art a = artRepository.addArt(art);
        return Response.ok().entity(a).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAll")
    public Response getAllArts() {
        List<Art> arts = artRepository.getAllArts();
        return Response.ok().entity(arts).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get")
    public Response getArtByTitle(@QueryParam("title") String title) {
        List<Art> arts;
        try {
            arts = artRepository.getArtByTitle(title);
        } catch (ArtException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(arts).build();
    }
}
