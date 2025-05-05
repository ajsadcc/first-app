package me.ajsa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity

public class Djelo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "djelo_seq")
    @SequenceGenerator(name = "djelo_seq", sequenceName = "djelo_seq", allocationSize = 1)
    private Integer id;

    private String naziv;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "djelo_id")
    public List<Kritika> kritike;


}
