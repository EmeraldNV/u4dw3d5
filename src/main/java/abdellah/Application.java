package abdellah;

import abdellah.entities.Catalogo;
import abdellah.entities.Libro;
import abdellah.entities.Rivista;
import abdellah.enumRivista.Periodicita;
import abdellah.repositories.CatalogoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4w3d5");




 public static void main(String[] args){

     Libro l = new Libro("Dune", "123-ABC", 1965, 700, "Frank Herbert", "Sci-Fi");
     Rivista r = new Rivista("Focus", "456-DEF", 2024, 50, Periodicita.MENSILE);
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     CatalogoRepository catalogoRepository = new CatalogoRepository(entityManager);

     catalogoRepository.save(l);
     catalogoRepository.save(r);

     catalogoRepository.findAndPrintByISBN("123-ABC");



     catalogoRepository.removeByISBN("123-ABC");
System.out.println("Funzia!");

 }}
