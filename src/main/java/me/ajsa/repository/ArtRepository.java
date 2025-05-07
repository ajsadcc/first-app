package me.ajsa.repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.ajsa.exception.ArtistException;
import me.ajsa.model.Artist;
import me.ajsa.model.Rating;
import me.ajsa.model.client.ArtistArt;

@Dependent
public class ArtistRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Artist createArtist(Artist a) {
        return em.merge(a);
    }

    @Transactional
    public List<Artist> getAllArtists() {
        List<Artist> artists = em.createNamedQuery(Artist.GET_ALL_ARTISTS, Artist.class).getResultList();

        for (Artist artist : artists) {
            List<Rating> ratings = em.createNamedQuery(Rating.GET_RATINGS_FOR_ARTIST, Rating.class)
                    .setParameter("id", artist.getId()).getResultList();

            artist.setRatings(new HashSet<>(ratings));
        }

        return artists;
    }

    public List<Artist> getArtistsByName(String name) throws ArtistException {
        List<Artist> artists = em.createNamedQuery(Artist.GET_ARTISTS_BY_NAME, Artist.class)
                .setParameter("name", name).getResultList();

        if(artists.isEmpty()) {
            throw new ArtistException("No artists found with that name");
        }

        return artists;
    }

    @Transactional
    public ArtistArt createArtistArt(ArtistArt a) {
        return em.merge(a);
    }
}