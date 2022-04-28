package it.philmark.docenza.services;

import it.philmark.docenza.DTO.PianetaDTO;
import it.philmark.docenza.models.Pianeta;

import java.util.List;

public interface PianetaService {

    List<PianetaDTO> getAllPianeti();

    PianetaDTO savePianeta(Pianeta pianetaDaSalvare);

    List<PianetaDTO> getPianetaByNome(String nomePianeta);

    List<PianetaDTO> getPianetaPiuDistanteDallaTerra(Long distanzaDallaTerra);





}
