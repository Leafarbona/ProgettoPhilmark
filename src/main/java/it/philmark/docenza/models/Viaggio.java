package it.philmark.docenza.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Viaggio {

    @Id // mi genera la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long velocitaMedia;

    private String nomeMissione;

    @Enumerated(EnumType.ORDINAL)
    private Astatus status;
}
