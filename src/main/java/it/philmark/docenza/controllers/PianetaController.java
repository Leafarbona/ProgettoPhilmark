package it.philmark.docenza.controllers;

import it.philmark.docenza.DTO.PianetaDTO;
import it.philmark.docenza.models.Pianeta;
import it.philmark.docenza.services.PianetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pianeti")
public class PianetaController {

    private static Logger logger = LoggerFactory.getLogger(PianetaController.class);

    @Autowired
    PianetaService pianetaService;

    @GetMapping("getAllPianeti")
    public ResponseEntity<?> getAllPianeti(){
        List<PianetaDTO> dtoList = pianetaService.getAllPianeti();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("savePianeta")
    public ResponseEntity<?> savePianeta(@RequestBody Pianeta p){
        PianetaDTO pianetaDTO = pianetaService.savePianeta(p);
        logger.info("Pianeta salvato correttamente: " + pianetaDTO.toString());
        return new ResponseEntity<>(pianetaDTO, HttpStatus.OK);
    }

    @GetMapping("getPianetaByNome/{nomePianeta}")
    public List<PianetaDTO> getPianetaByNome(@PathVariable String nomePianeta) {
        return pianetaService.getPianetaByNome(nomePianeta);
    }

}
