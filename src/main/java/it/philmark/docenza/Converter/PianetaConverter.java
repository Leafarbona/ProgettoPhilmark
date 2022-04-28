package it.philmark.docenza.Converter;

import it.philmark.docenza.DTO.PianetaDTO;
import it.philmark.docenza.models.Pianeta;

public class PianetaConverter {

    public static PianetaDTO fromEntityToDTO(Pianeta p){
        PianetaDTO dto = new PianetaDTO();
        dto.setId(p.getId());
        dto.setNomePianeta(p.getNomePianeta());
        dto.setDiametro(p.getDiametro());
        return dto;
    }
}
