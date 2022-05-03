package it.philmark.docenza.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class FilmAttori {

    @Id // mi genera la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double costoAttorePerFilm;

    //adesso andremo a sdoppiare la nostra relazione manytomany in due rlazione manytoone

    @ManyToOne
    private Attore attore;

    @ManyToOne
    private Film film;

}
