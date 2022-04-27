package it.philmark.docenza.services;

import it.philmark.docenza.models.Film;

import java.util.List;

public interface FIlmService {

    List<Film> getAllFilms();

    Film saveFilm(Film filmDaSalvare);
}
