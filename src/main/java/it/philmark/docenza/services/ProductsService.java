package it.philmark.docenza.services;

import it.philmark.docenza.DTO.ProductsDTO;
import it.philmark.docenza.models.Products;

import java.util.List;

public interface ProductsService {
    List<ProductsDTO> getAllProducts();

    ProductsDTO saveProduct(Products prodottoDaSalvare);

    ProductsDTO updateProduct(Products prodottoConModifiche);

    void deleteProduct(Long idProdottoDaEliminare);
}
