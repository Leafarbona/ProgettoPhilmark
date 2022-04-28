package it.philmark.docenza.services.impl;

import it.philmark.docenza.Converter.AstronaveConverter;
import it.philmark.docenza.DTO.AstronaveDTO;
import it.philmark.docenza.models.Astronave;
import it.philmark.docenza.repository.AstronaveRepository;
import it.philmark.docenza.services.AstronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AstronaveServiceImpl implements AstronaveService {

    @Autowired
    AstronaveRepository astronaveRepository;

    @Override
    public List<AstronaveDTO> getAllAstronavi() {
        List<Astronave> listaAstronave = astronaveRepository.findAll();
        List<AstronaveDTO> dtoList = new ArrayList<>();

        for (Astronave a : listaAstronave){
            dtoList.add(AstronaveConverter.fromEntityToDTO(a));
        }
        return dtoList;
    }

    @Override
    public AstronaveDTO saveAstronave(Astronave astronaveDaSalvare) {
        Astronave astronaveSalvata = astronaveRepository.save(astronaveDaSalvare);
        return AstronaveConverter.fromEntityToDTO(astronaveSalvata);
    }
}
