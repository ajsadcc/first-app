package me.ajsa.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Djelo {
    private int id;
    private String naziv;
    private String opis;
    private int godinaKreiranje;
    @OneToMany
    private int idUmjetnik;
    @OneToMany
    private int idVrsta;
    @ManyToMany
    private List<Kritika> kritike;

    public List<Kritika> getKritike() {
        return kritike;
    }

    public void setKritike(List<Kritika> kritike) {
        this.kritike = kritike;
    }


    public Djelo(int id, String naziv, String opis, int godinaKreiranje, int idUmjetnika, int idVrste) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.godinaKreiranje = godinaKreiranje;
        this.idUmjetnik = idUmjetnika;
        this.idVrsta = idVrste;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getGodinaKreiranje() {
        return godinaKreiranje;
    }

    public void setGodinaKreiranje(int godinaKreiranje) {
        this.godinaKreiranje = godinaKreiranje;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getIdUmjetnik() {
        return idUmjetnik;
    }

    public void setIdUmjetnik(int idUmjetnik) {
        this.idUmjetnik = idUmjetnik;
    }

    public int getIdVrsta() {
        return idVrsta;
    }

    public void setIdVrsta(int idVrsta) {
        this.idVrsta = idVrsta;
    }
}
