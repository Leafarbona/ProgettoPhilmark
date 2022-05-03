package it.philmark.docenza.controllers;


import it.philmark.docenza.models.Film;
import it.philmark.docenza.services.FIlmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/film")

public class FilmController {

    private static Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    FIlmService fIlmService;

    @GetMapping("getAllFilms")
    public ResponseEntity<?> getAllFilms(){
        List<Film> filmList = fIlmService.getAllFilms();
        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    @PostMapping("saveFilm")
    public ResponseEntity<?> saveFilm(@RequestBody Film f){
        Film filmDaSalvare = fIlmService.saveFilm(f);
        logger.info("Film salvato correttamente " + filmDaSalvare.toString());
        return new ResponseEntity<>(filmDaSalvare, HttpStatus.OK);
    }
}
