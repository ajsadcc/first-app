package me.ajsa.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;

@Entity

@NamedQuery(name = Art.GET_ALL_ARTS, query = "SELECT a FROM Art a")
@NamedQuery(name = Art.GET_ARTS_BY_ID, query = "SELECT a FROM Art a WHERE a.id = :id")
@NamedQuery(name = Art.GET_ARTS_BY_TITLE, query = "SELECT a FROM Art a WHERE a.title = :title")

public class Art {

    public static final String GET_ALL_ARTS = "Art.getAllArts";
    public static final String GET_ARTS_BY_TITLE = "Art.getArtsByTitle";
    public static final String GET_ARTS_BY_ID = "Art.getArtsById";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "art_seq")
    private Long id;

    private String title;
    private Date datumKreiranja;
    private String identifikator;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "art_id")
    private Set<Rating> ratings;

    private String fileName;
    private String filePath;

    public Art() {
        super();
    }

    public Art(Long id, String naslov, String autor, Date datumKreiranja, String identifikator, String fileName, String filePath) {
        super();
        this.id = id;
        this.title = naslov;
        this.datumKreiranja = datumKreiranja;
        this.identifikator = identifikator;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return title;
    }

    public void setNaslov(String naslov) {
        this.title = naslov;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((datumKreiranja == null) ? 0 : datumKreiranja.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((identifikator == null) ? 0 : identifikator.hashCode());
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
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (identifikator == null) {
            if (other.identifikator != null)
                return false;
        } else if (!identifikator.equals(other.identifikator))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Art [id=" + id + ", naslov=" + title + ", datumKreiranja=" + datumKreiranja
                + ", identifikator=" + identifikator + "]";
    }
}