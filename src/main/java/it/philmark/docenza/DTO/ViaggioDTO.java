package it.philmark.docenza.DTO;

import it.philmark.docenza.models.Astatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ViaggioDTO {

    private Long id;
    private Long velocitaMedia;
    private String nomeMissione;
    private Astatus astatus;
}
