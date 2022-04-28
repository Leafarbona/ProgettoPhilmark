package it.philmark.docenza.services.impl;

import it.philmark.docenza.Converter.ViaggioConverter;
import it.philmark.docenza.DTO.ViaggioDTO;
import it.philmark.docenza.models.Viaggio;
import it.philmark.docenza.repository.ViaggioRepository;
import it.philmark.docenza.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ViaggioServiceImpl implements ViaggioService {

    @Autowired
    ViaggioRepository viaggioRepository;

    @Override
    public List<ViaggioDTO> getAllViaggi() {
        List<Viaggio> viaggioList = viaggioRepository.findAll();
        List<ViaggioDTO> dtoList = new ArrayList<>();

        for (Viaggio v : viaggioList){
            dtoList.add(ViaggioConverter.fromEntityToDTO(v));
        }
        return dtoList;
    }

    @Override
    public ViaggioDTO saveViaggio(Viaggio viaggioDaSalvare) {
        Viaggio viaggioSalvato = viaggioRepository.save(viaggioDaSalvare);
        return ViaggioConverter.fromEntityToDTO(viaggioSalvato);
    }

    @Override
    public ViaggioDTO updateStatusViaggio(Viaggio viaggioConModifiche) {
        if (viaggioConModifiche.getId() != null){
            Viaggio viaggioDaModificare = viaggioRepository.getOne(viaggioConModifiche.getId());
            viaggioDaModificare.setNomeMissione(viaggioConModifiche.getNomeMissione());
            viaggioDaModificare.setVelocitaMedia(viaggioConModifiche.getVelocitaMedia());
            viaggioDaModificare.setStatus(viaggioConModifiche.getStatus());
            Viaggio viaggioModificato = viaggioRepository.save(viaggioDaModificare);
            return ViaggioConverter.fromEntityToDTO(viaggioModificato);
        }
     return null;

    }
}
