package me.ajsa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ArtistArt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artistart_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;

    @ManyToOne(cascade = CascadeType.ALL)
    private Art art;

    public ArtistArt() {
        super();
    }

    public ArtistArt(Artist artist, Art art) {
        super();
        this.artist = artist;
        this.art = art;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((art == null) ? 0 : art.hashCode());
        result = prime * result + ((artist == null) ? 0 : artist.hashCode());
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
        ArtistArt other = (ArtistArt) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (art == null) {
            if (other.art != null)
                return false;
        } else if (!art.equals(other.art))
            return false;
        if (artist == null) {
            if (other.artist != null)
                return false;
        } else if (!artist.equals(other.artist))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ArtistArt [id=" + id + ", artist=" + artist + ", art=" + art + "]";
    }
}