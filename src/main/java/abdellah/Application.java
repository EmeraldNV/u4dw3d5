package abdellah;

import abdellah.entities.Libro;
import abdellah.entities.Rivista;
import abdellah.enumRivista.Periodicita;
import abdellah.repositories.CatalogoRepository;
import abdellah.repositories.PrestitoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4w3d5");

    public static void main(String[] args) {


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CatalogoRepository catalogoRepository = new CatalogoRepository(entityManager);
        PrestitoRepository prestitoRepository = new PrestitoRepository(entityManager);

        Libro l1 = new Libro("Il Signore degli Anelli", "978-LOTR", 1954, 1200, "J.R.R. Tolkien", "Fantasy");
        Libro l2 = new Libro("1984", "978-1984", 1949, 328, "George Orwell", "Distopico");
        Libro l3 = new Libro("Il Nome della Rosa", "978-ECO", 1980, 512, "Umberto Eco", "Giallo Storico");
        Libro l4 = new Libro("Il Gattopardo", "978-GAT", 1958, 300, "Giuseppe Tomasi di Lampedusa", "Storico");

        Rivista r1 = new Rivista("National Geographic", "NG-2023", 2023, 100, Periodicita.MENSILE);
        Rivista r2 = new Rivista("L'Espresso", "EXP-2024", 2024, 85, Periodicita.SETTIMANALE);
        Rivista r3 = new Rivista("Le Scienze", "SCI-2022", 2022, 90, Periodicita.MENSILE);
        Rivista r4 = new Rivista("Wired", "WIRD-Q", 2023, 120, Periodicita.SEMESTRALE);

        catalogoRepository.save(l1);
        catalogoRepository.save(l2);
        catalogoRepository.save(l3);
        catalogoRepository.save(l4);
        catalogoRepository.save(r1);
        catalogoRepository.save(r2);
        catalogoRepository.save(r3);
        catalogoRepository.save(r4);

        catalogoRepository.findAndPrintByISBN("123-ABC");

        catalogoRepository.removeByISBN("123-ABC");

        catalogoRepository.findAndPrintByAnnoPubblicazione(1990);

        catalogoRepository.findAndPrintByAutore("Abdellah");

        catalogoRepository.findAndPrintByTitolo("Dun");

        prestitoRepository.findAndPrintInPrestitoByTessera("533656");

        prestitoRepository.findAndPrintPrestitiScaduti();

        System.out.println("Funzia!");

        entityManager.close();
        entityManagerFactory.close();
    }
}