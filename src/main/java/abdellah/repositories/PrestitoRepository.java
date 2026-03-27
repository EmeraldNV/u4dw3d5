package abdellah.repositories;

import abdellah.entities.Catalogo;
import abdellah.entities.Prestito;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class PrestitoRepository {
    private final EntityManager entityManager;

    public PrestitoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void findAndPrintInPrestitoByTessera(String numeroTessera) {
        List<Catalogo> risultati = entityManager.createQuery(
                        "SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numTessera = :n AND p.dataRestituzioneEffettiva IS NULL", Catalogo.class)
                .setParameter("n", numeroTessera)
                .getResultList();

        risultati.forEach(System.out::println);
    }

    public void findAndPrintPrestitiScaduti() {
        List<Prestito> risultati = entityManager.createQuery(
                        "SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < :oggi AND p.dataRestituzioneEffettiva IS NULL", Prestito.class)
                .setParameter("oggi", LocalDate.now())
                .getResultList();

        risultati.forEach(System.out::println);
    }

}
