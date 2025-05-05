package me.ajsa.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.ajsa.model.Djelo;

@Dependent
public class DjeloRepository {
    @Inject
    EntityManager em;
    @Transactional
public Djelo createDjelo(Djelo djelo){return em.merge(djelo);}

}
