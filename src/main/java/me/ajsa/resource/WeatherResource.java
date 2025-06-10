package me.ajsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.ajsa.model.client.Country;
import me.ajsa.model.client.Weather;
import me.ajsa.repository.HolidayRepository;
import me.ajsa.repository.WeatherRepository;
import me.ajsa.restclient.HolidayClient;
import me.ajsa.restclient.WeatherClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;


@Path("/get")
public class WeatherResource {

    @Inject
    @RestClient
    WeatherClient weatherClient;

    @Inject
    WeatherRepository weatherRepository;

    @GET
    @Path("/weather")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeather(@QueryParam("city") String city) {
        Weather w = weatherClient.getWeather(city);
        weatherRepository.addWeather(w);
        return Response.ok(w).build();
    }


}
