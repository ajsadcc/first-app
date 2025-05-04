package me.ajsa.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import me.ajsa.model.Kritika;

@ApplicationScoped
public class KritikaRepository implements PanacheRepository<Kritika> {
}
