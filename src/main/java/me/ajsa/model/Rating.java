package me.ajsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@NamedQuery(name = Rating.GET_ALL_RATINGS_BY_ART, query = "SELECT r FROM Rating r WHERE r.art.id = :id")
public class Rating {

    public static final String GET_ALL_RATINGS_BY_ART = "Rating.getRatingsByArt";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    @SequenceGenerator(name = "rating_seq", sequenceName = "rating_seq", allocationSize = 1)
    private Integer id;

    private Integer rating;
    private String text;

    @ManyToOne
    @JsonIgnore
    private Art art;
}
