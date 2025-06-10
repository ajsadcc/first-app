package me.ajsa.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.ajsa.model.client.Holiday;
import me.ajsa.model.client.HolidayDTO;
import me.ajsa.model.client.HolidayType;
import me.ajsa.model.client.Weather;

import java.util.ArrayList;
import java.util.List;


@Dependent
public class WeatherRepository {

        @Inject
        EntityManager em;

        @Transactional
        public Weather addWeather (Weather w) {
            return em.merge(w);
        }


}
