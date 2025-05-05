package me.ajsa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Kritika {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kritika_seq")
    @SequenceGenerator(name = "kritika_seq", sequenceName = "kritika_seq", allocationSize = 1)
    private Integer id;

    private String tekst;
    @ManyToOne
    private Djelo djelo;
}