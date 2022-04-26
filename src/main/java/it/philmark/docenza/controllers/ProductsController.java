package it.philmark.docenza.controllers;

import it.philmark.docenza.DTO.ProductsDTO;
import it.philmark.docenza.DTO.UserDTO;
import it.philmark.docenza.models.Products;
import it.philmark.docenza.services.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private static Logger logger = LoggerFactory.getLogger(ProductsController.class);


    @Autowired
    ProductsService productsService;


    @GetMapping("getAllProducts")
    public ResponseEntity<?> getAllProducts(){
        List<ProductsDTO> dtoList = productsService.getAllProducts();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Products p){
        ProductsDTO productsDTO = productsService.saveProduct(p);
        logger.info("Prodotto Salvato Corretamente: " + productsDTO.toString());
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }

    @PostMapping("updateProduct")
    public ResponseEntity<?> updateProduct(@RequestBody Products p){
        if (p.getId() != null){
            ProductsDTO productsDTO = productsService.updateProduct(p);
            logger.info("Prodotto modificato correttamente: " + productsDTO.toString());
            return new ResponseEntity<>(productsDTO, HttpStatus.OK);
        }
        logger.error("Inserisci il campo ID del prodotto per modificarlo!");
        return new ResponseEntity<>("Inserisci il campo ID dell prodotto per modificalo", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("deleteProduct/{idProdottoDaEliminare}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long idProdottoDaEliminare){
        productsService.deleteProduct(idProdottoDaEliminare);
        return new ResponseEntity<>("Prodotto eliminato corretamente", HttpStatus.OK);
    }
}
