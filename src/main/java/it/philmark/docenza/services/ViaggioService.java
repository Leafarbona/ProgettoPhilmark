package it.philmark.docenza.services;

import it.philmark.docenza.DTO.ViaggioDTO;
import it.philmark.docenza.models.Viaggio;

import java.util.List;

public interface ViaggioService {

    List<ViaggioDTO> getAllViaggi();

    ViaggioDTO saveViaggio(Viaggio viaggioDaSalvare);

    ViaggioDTO updateStatusViaggio(Viaggio viaggioConModifiche);

}
