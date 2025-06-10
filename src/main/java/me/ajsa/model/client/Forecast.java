package me.ajsa.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Forecast{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "forecast_seq")
    private Long id;
    public String day;
    public String temperature;
    public String wind;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name= "weather_id")
    private Weather weather;


    public Forecast(String day, String temperature, String wind) {
        this.day = day;
        this.temperature = temperature;
        this.wind = wind;
    }

    public Forecast() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}

