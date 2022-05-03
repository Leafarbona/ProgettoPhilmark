package it.philmark.docenza.services.impl;

import it.philmark.docenza.models.Film;
import it.philmark.docenza.repository.FilmRepository;
import it.philmark.docenza.services.FIlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FilmServiceImpl implements FIlmService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<Film> getAllFilms() {
        List<Film> listaFilm = filmRepository.findAll();
        return listaFilm;
    }

    @Override
    public Film saveFilm(Film filmDaSalvare) {
        Film filmSalvato = filmRepository.save(filmDaSalvare);
        return filmSalvato;
    }
}
