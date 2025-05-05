package me.ajsa.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.ajsa.exception.ArtException;
import me.ajsa.model.Art;
import me.ajsa.model.Rating;

import java.util.List;

@Dependent
public class ArtRepository {

    @Inject
    EntityManager em;

    @Transactional
    public Art addArt(Art art) {
        return em.merge(art);
    }

    @Transactional
    public List<Art> getAllArts() {
        List<Art> arts = em.createNamedQuery(Art.GET_ALL_ARTS, Art.class).getResultList();
        for (Art a : arts) {
            List<Rating> ratings = em.createNamedQuery(Rating.GET_ALL_RATINGS_BY_ART, Rating.class)
                    .setParameter("id", a.getId()).getResultList();
            a.setRatings(ratings);
        }
        return arts;
    }

    @Transactional
    public List<Art> getArtByTitle(String title) throws ArtException {
        List<Art> arts = em.createNamedQuery(Art.GET_ART_BY_TITLE, Art.class)
                .setParameter("title", title).getResultList();
        if (arts.isEmpty()) {
            throw new ArtException("No art found with title: " + title);
        }
        for (Art a : arts) {
            List<Rating> ratings = em.createNamedQuery(Rating.GET_ALL_RATINGS_BY_ART, Rating.class)
                    .setParameter("id", a.getId()).getResultList();
            a.setRatings(ratings);
        }
        return arts;
    }
}
