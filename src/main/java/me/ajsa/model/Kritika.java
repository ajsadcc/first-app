package me.ajsa.model;

import jakarta.persistence.*;

@Entity
public class Kritika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tekst;

    @ManyToOne
    @JoinColumn(name = "djelo_id")
    private Djelo djelo;

    // Getteri i setteri
    public Long getId() {
        return id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Djelo getDjelo() {
        return djelo;
    }

    public void setDjelo(Djelo djelo) {
        this.djelo = djelo;
    }
}
