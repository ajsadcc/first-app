package me.ajsa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import me.ajsa.model.Djelo;
import me.ajsa.model.Kritika;
import me.ajsa.repository.DjeloRepository;

import java.util.List;

@ApplicationScoped
public class DjeloService {

    private final DjeloRepository djeloRepository;

    public DjeloService(DjeloRepository djeloRepository) {
        this.djeloRepository = djeloRepository;
    }

    @Transactional
    public void createDjelo() {
        Djelo djelo = new Djelo();
        djelo.setNaziv("Mona Liza");

        Kritika k1 = new Kritika();
        k1.setTekst("Odlična slika!");
        k1.setDjelo(djelo);

        Kritika k2 = new Kritika();
        k2.setTekst("Zanimljiva kompozicija.");
        k2.setDjelo(djelo);

        djelo.setKritike(List.of(k1, k2));

        djeloRepository.persist(djelo);
    }
}
