package abdellah.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "users")

public class Utente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String cognome;

    @Column (name = "data_nascita")
    private LocalDate dataNascita;

    @Column (name = "num_Tessera", nullable = false, unique = true)
    private Integer numTessera;

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numTessera=" + numTessera +
                '}';
    }
}
