package it.philmark.docenza.Converter;

import it.philmark.docenza.DTO.AstronaveDTO;
import it.philmark.docenza.models.Astronave;

public class AstronaveConverter {

    public static AstronaveDTO fromEntityToDTO(Astronave a){
        AstronaveDTO dto = new AstronaveDTO();
        dto.setId(a.getId());
        dto.setNomeAstronave(a.getNomeAstronave());
        dto.setVelocitaMassima(a.getVelocitaMassima());
        return dto;
    }
}
