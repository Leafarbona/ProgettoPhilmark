package it.philmark.docenza.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PianetaDTO {

    private Long id;
    private String nomePianeta;
    private Long diametro;
    private Long distanzaDallaTerra;
}
