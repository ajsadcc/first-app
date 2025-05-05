package me.ajsa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@NamedQuery(name = Art.GET_ALL_ARTS, query = "SELECT a FROM Art a")
@NamedQuery(name = Art.GET_ART_BY_TITLE, query = "SELECT a FROM Art a WHERE a.title = :title")
public class Art {

    public static final String GET_ALL_ARTS = "Art.getAllArts";
    public static final String GET_ART_BY_TITLE = "Art.getArtByTitle";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "art_seq")
    @SequenceGenerator(name = "art_seq", sequenceName = "art_seq", allocationSize = 1)
    private Integer id;

    private String title;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "art_id") // Spoljašnji ključ u tabeli Rating
    private List<Rating> ratings;
}
