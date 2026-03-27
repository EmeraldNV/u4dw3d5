package abdellah.entities;

import abdellah.enumRivista.Periodicita;
import jakarta.persistence.*;

@Entity
@Table (name = "riviste")
public class Rivista extends Catalogo {

    @Column (nullable = false)
    private Long id;

    @Column (nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;


    public Rivista() {
    }


    public Rivista(String titolo, String codiceIsbn, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {

        super(titolo, codiceIsbn, annoPubblicazione, numeroPagine);

        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "id=" + id +
                ", periodicita=" + periodicita +
                "} " + super.toString();
    }
}
