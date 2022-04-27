package it.philmark.docenza.controllers;

import it.philmark.docenza.models.Attore;
import it.philmark.docenza.services.AttoriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attori")
public class AttoreController {

    private static Logger logger = LoggerFactory.getLogger(AttoreController.class);

    @Autowired
    AttoriService attoriService;

    @GetMapping("getAllAttori")
    public ResponseEntity<?> getAllAttori(){
        List<Attore> listaAttori = attoriService.getAllAttori();
        return new ResponseEntity<>(listaAttori, HttpStatus.OK);
    }

    @PostMapping("saveAttori")
    public ResponseEntity<?> saveAttori(@RequestBody Attore a){
        Attore attore = attoriService.saveAttore(a);
        logger.info("Attore salvato correttamente: " + attore.toString());
        return new ResponseEntity<>(attore, HttpStatus.OK);
    }
}
