package it.philmark.docenza.services.impl;

import it.philmark.docenza.models.FilmAttori;
import it.philmark.docenza.repository.FilmAttoriRepository;
import it.philmark.docenza.services.FilmAttoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmAttoriServiceImpl implements FilmAttoriService {

    @Autowired
    FilmAttoriRepository filmAttoriRepository;

    @Override
    public List<FilmAttori> getAllRelationship(){
        return filmAttoriRepository.findAll();
    }

    @Override
    public FilmAttori associateFilmToActors(FilmAttori f) {
        return null;
    }

    @Override
    public FilmAttori associateFilmsToActors(FilmAttori f){
        return filmAttoriRepository.save(f);
    }
}
