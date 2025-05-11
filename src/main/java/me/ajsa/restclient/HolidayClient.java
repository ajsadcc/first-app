package me.ajsa.restclient;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.ajsa.model.client.Country;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/v3")
@RegisterRestClient(configKey = "holiday-api")
public interface HolidayClient {

    @GET
    @Path("/AvailableCountries")
    List<Country> getAllCountries();




}
