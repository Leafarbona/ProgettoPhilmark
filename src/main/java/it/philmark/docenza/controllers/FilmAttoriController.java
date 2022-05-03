package it.philmark.docenza.controllers;

import it.philmark.docenza.models.Attore;
import it.philmark.docenza.models.Film;
import it.philmark.docenza.models.FilmAttori;
import it.philmark.docenza.services.FilmAttoriService;
import it.philmark.docenza.services.impl.FilmAttoriServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/filmAttori")
public class FilmAttoriController {

    @Autowired
    FilmAttoriService filmAttoriService;

    public ResponseEntity<?> getAllRelationshipFilmActors(){
        return new ResponseEntity<>(filmAttoriService.getAllRelationship(), HttpStatus.OK);
    }
    @RequestMapping("getAllFilmAndActors")
    public ResponseEntity<?> getAllFilmAndActors(){
        List<FilmAttori> listaAttori = filmAttoriService.getAllFilmAndActors();
        return new ResponseEntity<>(listaAttori, HttpStatus.OK);
    }

    @PostMapping("associateFilmWithActors")
    public ResponseEntity<?> associateFilmWithActors(@RequestBody FilmAttori f) {
        return new ResponseEntity<>(filmAttoriService.associateFilmToActors(f), HttpStatus.OK);
    }
}


