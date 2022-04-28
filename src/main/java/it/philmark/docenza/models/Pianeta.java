package it.philmark.docenza.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Pianeta {
    @Id // mi genera la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //non puo essere vuoto
    @Size(max = 20) //lunghezza massima
    private String nomePianeta;

    @NotBlank //non puo essere vuoto
    private Long diametro;


    @NotBlank //non puo essere vuoto
    private Long distanzaDallaTerra;



}
