package it.philmark.docenza.services;

import it.philmark.docenza.models.FilmAttori;

import java.util.List;

public interface FilmAttoriService {



        List<FilmAttori> getAllRelationship();

        FilmAttori associateFilmToActors(FilmAttori f);

    FilmAttori associateFilmsToActors(FilmAttori f);
    List<FilmAttori> getAllFilmAndActors();
}


