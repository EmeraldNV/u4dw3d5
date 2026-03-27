package abdellah.repositories;

import abdellah.entities.Catalogo;
import abdellah.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class CatalogoRepository {
    private final EntityManager entityManager;

    public CatalogoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Catalogo catalogo) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(catalogo);
        transaction.commit();
    }


    public void findAndPrintByISBN(String isbn) {
        try {
            Catalogo c = entityManager
                    .createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :isbn", Catalogo.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            System.out.println(c);
        } catch (NoResultException e) {
            System.out.println("Nessun elemento trovato per ISBN: " + isbn);
        }
    }

    public void removeByISBN(String isbn) {
        try {
            Catalogo catalogoFound = entityManager
                    .createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :isbn", Catalogo.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();

            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(catalogoFound);
            transaction.commit();
        } catch (NoResultException e) {
            System.out.println("Cancellazione annullata: ISBN " + isbn + " non trovato.");
        }
    }

    public void findAndPrintByAnnoPubblicazione(int anno) {
        List<Catalogo> risultati = entityManager
                .createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno", Catalogo.class)
                .setParameter("anno", anno)
                .getResultList();

        if (risultati.isEmpty()) {
            System.out.println("Nessun risultato per l'anno: " + anno);
        } else {
            risultati.forEach(System.out::println);
        }
    }

    public void findAndPrintByAutore(String autore) {
        List<Libro> risultati = entityManager
                .createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class)
                .setParameter("autore", autore)
                .getResultList();

        if (risultati.isEmpty()) {
            System.out.println("Nessun libro trovato per l'autore: " + autore);
        } else {
            risultati.forEach(System.out::println);
        }
    }

    public void findAndPrintByTitolo(String titolo) {
        List<Catalogo> risultati = entityManager.createQuery(
                        "SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE :t", Catalogo.class)
                .setParameter("t", "%" + titolo.toLowerCase() + "%")
                .getResultList();

        if (risultati.isEmpty()) {
            System.out.println("Nessun risultato per il titolo: " + titolo);
        } else {
            risultati.forEach(System.out::println);
        }
    }


}