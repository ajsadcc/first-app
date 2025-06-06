package me.ajsa.model.client;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "holiday_seq")
    private Integer id;
    private String localName;
    private String name;
    private String countryCode;
    private boolean global;
    @ElementCollection
    private List<String> counties;
    private int launchYear;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HolidayType> types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getCounties() {
        return counties;
    }

    public void setCounties(List<String> counties) {
        this.counties = counties;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(int launchYear) {
        this.launchYear = launchYear;
    }

    public List<HolidayType> getTypes() {
        return types;
    }

    public void setTypes(List<HolidayType> types) {
        this.types = types;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
    }
}
