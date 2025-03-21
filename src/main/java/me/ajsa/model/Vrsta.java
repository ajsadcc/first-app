package me.ajsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vrsta {
    @Id
    private int id;
    private String naziv;

    public Vrsta(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


}
