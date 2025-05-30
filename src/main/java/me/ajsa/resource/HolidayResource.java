package me.ajsa.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import me.ajsa.model.client.Country;
import me.ajsa.model.client.HolidayDTO;
import me.ajsa.model.client.Holiday;
import me.ajsa.repository.HolidayRepository;
import me.ajsa.restclient.HolidayClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/holidays")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HolidayResource {

    @Inject
    @RestClient
    HolidayClient holidayClient;

    @Inject
    HolidayRepository holidayRepository;

    @GET
    @Path("/countries")
    public List<Country> getCountries() {
        return holidayClient.getAvailableCountries();
    }

    @GET
    @Path("/getNext/{countryCode}")
    public List<Holiday> getAndSaveNextHolidays(@PathParam("countryCode") String code) {
        List<HolidayDTO> dtos = holidayClient.getNextPublicHolidays(code);

        List<Holiday> holidays = holidayRepository.fromDtoList(dtos);
        holidayRepository.saveIfNotExists(holidays);

        return holidays;
    }
}

