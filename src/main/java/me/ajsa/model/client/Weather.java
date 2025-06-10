package me.ajsa.model.client;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Weather {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "weather_seq")
        private Long id;
        public String temperature;
        public String wind;
        public String description;
        @OneToMany(cascade = CascadeType.ALL)
        public List<Forecast> forecast;

        public Weather() {
        }

        public Weather(String temperature, String wind, String description, List<Forecast> forecast) {
                this.temperature = temperature;
                this.wind = wind;
                this.description = description;
                this.forecast = forecast;
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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public List<Forecast> getForecast() {
                return forecast;
        }

        public void setForecast(List<Forecast> forecast) {
                this.forecast = forecast;
        }
}
