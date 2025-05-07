package me.ajsa.sheduel;

import org.eclipse.microprofile.rest.client.inject.RestClient;
//
//import io.quarkus.scheduler.Scheduled;
import me.ajsa.model.client.ArtTimeMetrics;
import me.ajsa.restclient.TimeClient;

public class SchedulerUtil {

    @RestClient
    TimeClient timeClient;

    //@Scheduled(every="1s")
    void getTime() {
        ArtTimeMetrics time = timeClient.getTime("Europe/Amsterdam");
        System.out.println(time);
    }

}