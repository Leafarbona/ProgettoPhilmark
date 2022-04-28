package it.philmark.docenza.services;

import it.philmark.docenza.DTO.AstronaveDTO;
import it.philmark.docenza.models.Astronave;

import java.util.List;

public interface AstronaveService {

    List<AstronaveDTO> getAllAstronavi();

    AstronaveDTO saveAstronave(Astronave astronaveDaSalvare);





}
