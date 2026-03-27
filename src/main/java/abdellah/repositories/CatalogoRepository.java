package abdellah.repositories;

import abdellah.entities.Catalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class CatalogoRepository {
    private final EntityManager entityManager;

    public CatalogoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Catalogo findByID(Integer catalogoId){
        Catalogo found = entityManager.find(Catalogo.class, catalogoId);

       // if (found == null ) {
       //     System.out.println("lo studente con id: " + catalogoId + "non e' stato trovato");
       //     throw new NotFoundException(catalogoId); }
        return found;

        }

    public Catalogo findByISBN(String isbn){
        try {
            return entityManager
                    .createQuery("SELECT c FROM Catalogo c WHERE c.codiceISBN = :isbn", Catalogo.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
            return null;

        }
    }

    public void findAndPrintByISBN (String isbn){
        Catalogo risultatoRicerca = this.findByISBN(isbn);

        if(risultatoRicerca != null){
            System.out.println(risultatoRicerca);
        }  else {
            System.out.println("Nessun elemento trovato per ISBN: " + isbn);
        }
    }

    public void removeByISBN(String isbn){

        Catalogo catalogoFound = this.findByISBN(isbn);

        if (catalogoFound == null) {
            System.out.println("Cancellazione annullata: ISBN " + isbn + " non trovato.");
            return;
        }

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


            entityManager.remove(catalogoFound);

        transaction.commit();
    }


    public void save(Catalogo catalogo){

        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(catalogo);

        transaction.commit();
    }
}
