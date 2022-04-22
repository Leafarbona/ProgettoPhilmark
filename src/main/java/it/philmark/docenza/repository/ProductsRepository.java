package it.philmark.docenza.repository;

import it.philmark.docenza.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
