package me.ajsa.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
        @NamedQuery(name = Art.GET_ALL_ARTS, query = "Select a from Art a"),
        @NamedQuery(name = Art.GET_ARTS_BY_TITLE, query = "Select a from Art a where a.naslov = :title"),
})
public class Art {

    public static final String GET_ALL_ARTS = "Art.getAllArts";
    public static final String GET_ARTS_BY_TITLE = "Art.getArtsByTitle";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "art_seq")
    private Long id;

    private String naslov; // umjesto ime
    private String autor;  // umjesto prezime
    private Date datumKreiranja; // umjesto datumRodjenja
    private String identifikator; // umjesto jmbg

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "art_id")
    private Set<Rating> ratings; // umjesto telefoni

    public Art() {
        super();
    }

    public Art(Long id, String naslov, String autor, Date datumKreiranja, String identifikator) {
        super();
        this.id = id;
        this.naslov = naslov;
        this.autor = autor;
        this.datumKreiranja = datumKreiranja;
        this.identifikator = identifikator;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public void setIdentifikator(String identifikator) {
        this.identifikator = identifikator;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datumKreiranja == null) ? 0 : datumKreiranja.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
        result = prime * result + ((identifikator == null) ? 0 : identifikator.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
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
        Art other = (Art) obj;
        if (datumKreiranja == null) {
            if (other.datumKreiranja != null)
                return false;
        } else if (!datumKreiranja.equals(other.datumKreiranja))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (naslov == null) {
            if (other.naslov != null)
                return false;
        } else if (!naslov.equals(other.naslov))
            return false;
        if (identifikator == null) {
            if (other.identifikator != null)
                return false;
        } else if (!identifikator.equals(other.identifikator))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Art [id=" + id + ", naslov=" + naslov + ", autor=" + autor + ", datumKreiranja=" + datumKreiranja
                + ", identifikator=" + identifikator + "]";
    }
}