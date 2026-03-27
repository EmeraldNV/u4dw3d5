package abdellah.entities;


import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "cataloghi")
public abstract class Catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long id;

    @Column (name = "codice_isbn" , nullable = false, unique = true)
    private String codiceISBN;

    @Column (name = "titolo" , nullable = false)
    private String titolo;

    @Column (name = "anno_pubblicazione" , nullable = false)
    private Integer annoPubblicazione;

    @Column (name = "num_pagine" , nullable = false)
    private Integer numPagine;

    public Catalogo() {
    }

    public Catalogo(String titolo, String codiceIsbn, Integer annoPubblicazione, Integer numeroPagine) {
        this.titolo = titolo;
        this.codiceISBN = codiceIsbn;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numeroPagine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(Integer numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }


}
