package me.ajsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Umjetnik {
    @Id
    private int id;
    private String ime;
    private String prezime;
    private int godinaRodjenja;

    public Umjetnik(int id, String ime, String prezime, int godinaRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }
}
