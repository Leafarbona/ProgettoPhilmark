package it.philmark.docenza.Converter;

import it.philmark.docenza.DTO.ProductsDTO;
import it.philmark.docenza.models.Products;

public class ProductsCoverter {

    public static ProductsDTO fromEntityToDTO(Products p){
        ProductsDTO dto = new ProductsDTO();
        dto.setId(p.getId());
        dto.setDescrizione(p.getDescrizione());
        dto.setImportoCad(p.getImportoCad());
        return dto;
    }
}
