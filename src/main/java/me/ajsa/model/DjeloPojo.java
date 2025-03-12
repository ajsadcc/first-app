package me.ajsa.model;

public class DjeloPojo {
    private int id;
    private String naziv;
    private String opis;
    private int godinaKreiranje;
    private int idUmjetnika;
    private int idVrste;

    public DjeloPojo(int id, String naziv, String opis, int godinaKreiranje, int idUmjetnika, int idVrste) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.godinaKreiranje = godinaKreiranje;
        this.idUmjetnika = idUmjetnika;
        this.idVrste = idVrste;
    }

    public int getId() {
        return id;
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

    public int getIdUmjetnika() {
        return idUmjetnika;
    }

    public void setIdUmjetnika(int idUmjetnika) {
        this.idUmjetnika = idUmjetnika;
    }

    public int getIdVrste() {
        return idVrste;
    }

    public void setIdVrste(int idVrste) {
        this.idVrste = idVrste;
    }
}
