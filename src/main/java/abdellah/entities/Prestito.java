package abdellah.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "prestiti")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






    @ManyToOne
    @JoinColumn(name = "utente", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato", nullable = false)
    private Catalogo elementoPrestato;

    @Column (name = "inizio_prestito", nullable = false)
    private LocalDate inizioPrestito;

    @Column (name = "data_rest_prevista", nullable = false)
    private LocalDate dataRestituzionePrevista;

    @Column (name = "data_rest_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", elementoPrestato=" + elementoPrestato +
                ", inizioPrestito=" + inizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}

