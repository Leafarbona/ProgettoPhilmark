package it.philmark.docenza.controllers;

import it.philmark.docenza.DTO.ViaggioDTO;
import it.philmark.docenza.models.Viaggio;
import it.philmark.docenza.services.ViaggioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    private static Logger logger = LoggerFactory.getLogger(ViaggioController.class);

    @Autowired
    ViaggioService viaggioService;

    @GetMapping("getAllViaggi")
    public ResponseEntity<?> getAllViaggi(){
        List<ViaggioDTO> dtoList = viaggioService.getAllViaggi();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("saveViaggi")
    public ResponseEntity<?> saveViaggio(@RequestBody Viaggio v){
        ViaggioDTO dto = viaggioService.saveViaggio(v);
        logger.info("Viaggio salvato correttamente: " + dto.toString());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("updateStatusViaggio")
    public ResponseEntity<?> updateStatusViaggio(@RequestBody Viaggio v){
        if (v.getId() != null){
            ViaggioDTO dto = viaggioService.updateStatusViaggio(v);
            logger.info("Viaggio modificato con successti: " + dto.toString());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        logger.error("Inserisci il campo ID del viaggio per modificarlo!");
        return new ResponseEntity<>("Inserisci il campo ID del viaggio per modificarlo!", HttpStatus.BAD_REQUEST);
    }
}
