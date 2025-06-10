package me.ajsa.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.ajsa.model.client.Weather;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/weather")
@RegisterRestClient(configKey = "weather")
public interface WeatherClient {


    @GET
    @Path("{city}")
    Weather getWeather(@PathParam("city") String city);
}
