package abdellah.entities;


import jakarta.persistence.*;

@Entity
@Table (name = "libri")

public class Libro extends Catalogo{

    public Libro (){

    }

    public Libro(String titolo, String codiceIsbn, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {
        // Passiamo i dati comuni al costruttore di Catalogo
        super(titolo, codiceIsbn, annoPubblicazione, numeroPagine);
        // Settiamo i dati specifici del Libro
        this.autore = autore;
        this.genere = genere;
    }


    @Column (nullable = false)
    private String autore;

    @Column (nullable = false)
    private String genere;

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                "} " + super.toString();
    }
}
