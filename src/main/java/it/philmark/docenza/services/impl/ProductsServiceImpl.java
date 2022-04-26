package it.philmark.docenza.services.impl;

import it.philmark.docenza.Converter.ProductsCoverter;
import it.philmark.docenza.DTO.ProductsDTO;
import it.philmark.docenza.models.Products;
import it.philmark.docenza.repository.ProductsRepository;
import it.philmark.docenza.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<ProductsDTO> getAllProducts() {
         List<Products> productsList = productsRepository.findAll();
         List<ProductsDTO> productsDTOList = new ArrayList<>();

         for (Products p : productsList){
             productsDTOList.add(ProductsCoverter.fromEntityToDTO(p));
         }
         return productsDTOList;
    }

    @Override
    public ProductsDTO saveProduct(Products prodottoDaSalvare) {
         Products prodottoSalvato = productsRepository.save(prodottoDaSalvare);
         return ProductsCoverter.fromEntityToDTO(prodottoSalvato);
    }

    @Override
    public ProductsDTO updateProduct(Products prodottoConModifiche) {
        if (prodottoConModifiche.getId() != null){
            Products prodottoDaModificare = productsRepository.getOne(prodottoConModifiche.getId());
            prodottoDaModificare.setId(prodottoConModifiche.getId());
            prodottoDaModificare.setDescrizione(prodottoConModifiche.getDescrizione());
            prodottoDaModificare.setImportoCad(prodottoConModifiche.getImportoCad());
            Products prodottoModificato = productsRepository.save(prodottoDaModificare);
            return ProductsCoverter.fromEntityToDTO(prodottoModificato);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long idProdottoDaEliminare) {
        Products prodottoDaEliminare = productsRepository.getOne(idProdottoDaEliminare);
        productsRepository.delete(prodottoDaEliminare);

    }
}
