package me.ajsa.model.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;


@Entity
public class HolidayType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_type_seq")
    private Long id;

    private String type;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    @JsonIgnore
    private Holiday holiday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
}
