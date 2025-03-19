package me.ajsa.model;

import jakarta.persistence.ManyToMany;

import java.util.List;

public class Kriticar {
    private int id;
    private String ime;
    private String prezime;
    private int godinaRodjenja;
    @ManyToMany
    private List<Kritika> kritike;

    @ManyToMany
    public List<Kritika> getKritike() {
        return kritike;
    }

    public void setKritike(List<Kritika> kritike) {
        this.kritike = kritike;
    }

    public Kriticar(int id, String ime, String prezime, int godinaRodjenja) {
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
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
