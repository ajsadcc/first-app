package me.ajsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Kritika {
    @Id
    private int id;
    private int idDjela;
    private int idKriticar;
    private int ocjena;
    private String obrazlozenje;
//medjutabela
    public Kritika(int idDjela, int idKriticar, int ocjena, String obrazlozenje) {
        this.idDjela = idDjela;
        this.idKriticar = idKriticar;
        this.ocjena = ocjena;
        this.obrazlozenje = obrazlozenje;
    }

    public int getIdDjela() {
        return idDjela;
    }

    public void setIdDjela(int idDjela) {
        this.idDjela = idDjela;
    }

    public int getIdKriticar() {
        return idKriticar;
    }

    public void setIdKriticar(int idKriticar) {
        this.idKriticar = idKriticar;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public String getObrazlozenje() {
        return obrazlozenje;
    }

    public void setObrazlozenje(String obrazlozenje) {
        this.obrazlozenje = obrazlozenje;
    }
}
