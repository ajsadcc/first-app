package me.ajsa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_seq")
    private Long id;

    private String naziv;
    private Integer reting;  // Ekvivalent "telefon" u originalnom kontekstu

    public Artist() {
        super();
    }

    public Artist(String naziv, Integer reting) {
        super();
        this.naziv = naziv;
        this.reting = reting;
    }

    // Getters i setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getReting() {
        return reting;
    }

    public void setReting(Integer reting) {
        this.reting = reting;
    }

    // hashCode, equals, toString
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
        result = prime * result + ((reting == null) ? 0 : reting.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artist other = (Artist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (naziv == null) {
            if (other.naziv != null)
                return false;
        } else if (!naziv.equals(other.naziv))
            return false;
        if (reting == null) {
            if (other.reting != null)
                return false;
        } else if (!reting.equals(other.reting))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Artist [id=" + id + ", naziv=" + naziv + ", reting=" + reting + "]";
    }
}
