package me.ajsa.restclient;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import me.ajsa.model.client.ArtTimeMetrics;

@Path("/time/current/")
@RegisterRestClient(configKey = "time-api")
public interface TimeClient {

    @GET
    @Path("/zone")
    ArtTimeMetrics getTime(@QueryParam("timeZone") String timeZone);

    @GET
    @Path("/coordinate")
    ArtTimeMetrics getCoordinate(@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude);

    @GET
    @Path("/ip")
    ArtTimeMetrics getIp(@QueryParam("ipAddress") String ipAddress);

}

