package me.ajsa.restclient;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.ajsa.model.client.Country;
import me.ajsa.model.client.HolidayDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/api/v3")
@RegisterRestClient(configKey = "holiday-api")
public interface HolidayClient {

    @GET
    @Path("/AvailableCountries")
    List<Country> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<HolidayDTO> getNextPublicHolidays(@PathParam("countryCode") String countryCode);


}

