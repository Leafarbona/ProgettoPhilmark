package it.philmark.docenza.repository;

import it.philmark.docenza.models.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttoriRepository extends JpaRepository<Attore, Long> {
}
