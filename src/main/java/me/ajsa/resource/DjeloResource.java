package me.ajsa.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.ajsa.model.Djelo;
import me.ajsa.model.Kritika;
import me.ajsa.repository.DjeloRepository;

import java.util.List;

@Path("/djelo/")
public class DjeloResource {
    @Inject
    private  DjeloRepository djeloRepository;


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response createDjelo(Djelo djelo){
        Djelo d = djeloRepository.createDjelo(djelo);
        return Response.ok().entity(d).build();
    }


}
