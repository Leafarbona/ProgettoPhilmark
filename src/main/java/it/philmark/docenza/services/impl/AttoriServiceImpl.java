package it.philmark.docenza.services.impl;

import it.philmark.docenza.models.Attore;
import it.philmark.docenza.repository.AttoriRepository;
import it.philmark.docenza.services.AttoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttoriServiceImpl implements AttoriService {

    @Autowired
    AttoriRepository attoriRepository;

   @Override
    public List<Attore> getAllAttori() {
        List<Attore> listaAttori = attoriRepository.findAll();
        List<Attore> attoreList = new ArrayList<>();
        return attoreList;
    }

    @Override
    public Attore saveAttore(Attore attoreDaSalvare) {
        Attore attoreSlavato = attoriRepository.save(attoreDaSalvare);
        return attoreSlavato;
    }
}
