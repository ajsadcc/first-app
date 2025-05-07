package me.ajsa.model;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Rating.GET_RATINGS_FOR_ART",
        query = "SELECT r FROM Rating r WHERE r.art.id = :id")
public class Rating {

    public static final String GET_RATINGS_FOR_ART = "Rating.getRatingsForArt";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_seq")
    private Long id;
    private int ocjena;  // Zamjena za prefiks (brojčana ocjena)
    private String komentar; // Zamjena za broj

    @ManyToOne
    @JoinColumn(name = "art_id")
    private Art art; // Zamjena za Student vezu

    public Rating() {
        super();
    }

    public Rating(Long id, int ocjena, String komentar) {
        super();
        this.id = id;
        this.ocjena = ocjena;
        this.komentar = komentar;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcjena() {
        return ocjena;
    }

    public void setOcjena(int ocjena) {
        this.ocjena = ocjena;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
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
        result = prime * result + ((komentar == null) ? 0 : komentar.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ocjena;
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
        Rating other = (Rating) obj;
        if (komentar == null) {
            if (other.komentar != null)
                return false;
        } else if (!komentar.equals(other.komentar))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ocjena != other.ocjena)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Rating [id=" + id + ", ocjena=" + ocjena + ", komentar=" + komentar + "]";
    }
}