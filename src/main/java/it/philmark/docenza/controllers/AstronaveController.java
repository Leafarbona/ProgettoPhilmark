package it.philmark.docenza.controllers;

import it.philmark.docenza.DTO.AstronaveDTO;
import it.philmark.docenza.models.Astronave;
import it.philmark.docenza.services.AstronaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/astronave")
public class AstronaveController {

    private static Logger logger = LoggerFactory.getLogger(AstronaveController.class);

    @Autowired
    AstronaveService astronaveService;


    @GetMapping("getAllAstronavi")
    public ResponseEntity<?> getAllAstronavi(){
        List<AstronaveDTO> dtoList = astronaveService.getAllAstronavi();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("saveAstronave")
    public ResponseEntity<?> saveAstronave(@RequestBody Astronave a){
        AstronaveDTO dto = astronaveService.saveAstronave(a);
        logger.info("Astronave salvata correttamente: " + dto.toString());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
