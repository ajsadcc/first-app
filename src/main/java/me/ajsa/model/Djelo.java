package me.ajsa.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Djelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    @OneToMany(mappedBy = "djelo", cascade = CascadeType.ALL)
    public List<Kritika> kritike;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Kritika> getKritike() {
        return kritike;
    }

    public void setKritike(List<Kritika> kritike) {
        this.kritike = kritike;
    }
}
