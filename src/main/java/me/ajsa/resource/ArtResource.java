package me.ajsa.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.List;

import me.ajsa.model.ArtistArt;
import me.ajsa.model.client.Country;
import me.ajsa.restclient.HolidayClient;
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
import me.ajsa.repository.ArtRepository;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import static me.ajsa.resource.FileUploadForm.UPLOAD_DIR;

@Path("/art/")
public class ArtResource {

    @Inject
    private ArtRepository artRepository;

    @Inject
    @RestClient
    private HolidayClient holidayClient;

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


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createArtArtist")
    public Response createArtArtist(ArtistArt a) {
        ArtistArt artArtist = artRepository.createArtistArt(a);
        return Response.ok().entity(artArtist).build();
    }

    @GET
    @Produces
    @Path("getCountries")
    public List<Country> getAllCountries(){
        List<Country> countries = holidayClient.getAvailableCountries();
        return countries;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("upload")
    public Response uploadProfileFile(@MultipartForm FileUploadForm form, @QueryParam("id") Integer id) {
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing 'id' query parameter.").build();
        }
        if (form == null || form.file == null || form.filename == null || form.filename.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("File and filename must be provided.").build();
        }

        Art art;
        try {
            art = artRepository.getArtsById(id);
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).entity("Art with id " + id + " not found.").build();
        }

        try {
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            java.nio.file.Path filePath = Paths.get(UPLOAD_DIR, form.filename);
            try (OutputStream out = new FileOutputStream(filePath.toFile())) {
                form.file.transferTo(out);
            }

            art.setFilePath(filePath.toAbsolutePath().toString());
            art.setFileName(form.filename);
            artRepository.createArt(art);

            return Response.ok("File uploaded successfully.").build();
        } catch (IOException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to upload file.").build();
        }
    }



}