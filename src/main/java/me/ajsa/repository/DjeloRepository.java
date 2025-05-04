package me.ajsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import me.ajsa.model.Djelo;

@ApplicationScoped
public class DjeloRepository implements PanacheRepository<Djelo> {
}
