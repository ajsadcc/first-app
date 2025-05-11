package me.ajsa.repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.ajsa.exception.ArtException;
import me.ajsa.model.Art;
import me.ajsa.model.Rating;
import me.ajsa.model.client.ArtistArt;

@Dependent
public class ArtRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Art createArt(Art art) {
        return em.merge(art);
    }

    @Transactional
    public List<Art> getAllArts() {
        List<Art> arts = em.createNamedQuery(Art.GET_ALL_ARTS, Art.class).getResultList();
        for (Art art : arts) {
            List<Rating> ratings = em.createNamedQuery(Rating.GET_RATINGS_FOR_ART, Rating.class)
                    .setParameter("id", art.getId()).getResultList();

            art.setRatings(new HashSet<>(ratings));
        }

        return arts;
    }

    @Transactional
    public List<Art> getArtsByName(String name) throws ArtException {
        List<Art> arts = em.createNamedQuery(Art.GET_ARTS_BY_TITLE, Art.class)
                .setParameter("name", name).getResultList();

        if(arts.isEmpty()) {
            throw new ArtException("No artworks found");
        }

        return arts;
    }

    @Transactional
    public ArtistArt createArtistArt(ArtistArt artArtist) {
        return em.merge(artArtist);
    }
}