package it.philmark.docenza.Converter;

import it.philmark.docenza.DTO.ViaggioDTO;
import it.philmark.docenza.models.Viaggio;

public class ViaggioConverter {

    public static ViaggioDTO fromEntityToDTO(Viaggio a){
        ViaggioDTO dto = new ViaggioDTO();
        dto.setId(a.getId());
        dto.setVelocitaMedia(a.getVelocitaMedia());
        dto.setAstatus(a.getStatus());
        return dto;
    }
}
