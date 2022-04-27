package it.philmark.docenza.DTO;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductsDTO {

    private Long id;
    private String descrizione;
    private Double importoCad;
}
