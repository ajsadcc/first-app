package me.ajsa.sheduel;

import org.eclipse.microprofile.rest.client.inject.RestClient;


import me.ajsa.model.client.ArtTimeMetrics;
import me.ajsa.restclient.TimeClient;

public class SchedulerUtil {

    @RestClient
    TimeClient timeClient;


    void getTime() {
        ArtTimeMetrics time = timeClient.getTime("Europe/Amsterdam");
        System.out.println(time);
    }
}