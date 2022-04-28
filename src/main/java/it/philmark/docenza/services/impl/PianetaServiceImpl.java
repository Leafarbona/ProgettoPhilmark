package it.philmark.docenza.services.impl;

import it.philmark.docenza.Converter.PianetaConverter;
import it.philmark.docenza.DTO.PianetaDTO;
import it.philmark.docenza.models.Pianeta;
import it.philmark.docenza.repository.PieanetaRepository;
import it.philmark.docenza.services.PianetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PianetaServiceImpl implements PianetaService {

    @Autowired
    PieanetaRepository pieanetaRepository;

    @Override
    public List<PianetaDTO> getAllPianeti() {
        List<Pianeta> listaPianeti = pieanetaRepository.findAll();
        List<PianetaDTO> dtoList = new ArrayList<>();

        for (Pianeta p : listaPianeti){
            dtoList.add(PianetaConverter.fromEntityToDTO(p));
        }
        return dtoList;
    }

    @Override
    public PianetaDTO savePianeta(Pianeta pianetaDaSalvare) {
        Pianeta pianetaSalvato = pieanetaRepository.save(pianetaDaSalvare);
        return PianetaConverter.fromEntityToDTO(pianetaSalvato);
    }

    @Override
    public List<PianetaDTO> getPianetaByNome(String nomePianeta) {
        return pieanetaRepository.getPianetaByName(nomePianeta);
    }

    @Override
    public List<PianetaDTO> getPianetaPiuDistanteDallaTerra(Long distanzaDallaTerra) {
        return pieanetaRepository.getPianetaPiuDistanteDallaTerra(distanzaDallaTerra);
    }
}
