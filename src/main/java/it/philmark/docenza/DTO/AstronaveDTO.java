package it.philmark.docenza.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AstronaveDTO {

    private Long id;
    private String nomeAstronave;
    private Long velocitaMassima;
}
