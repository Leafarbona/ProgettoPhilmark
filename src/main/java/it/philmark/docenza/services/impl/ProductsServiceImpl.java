package it.philmark.docenza.services.impl;

import it.philmark.docenza.repository.ProductsRepository;
import it.philmark.docenza.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

}
