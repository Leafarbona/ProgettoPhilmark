package it.philmark.docenza.repository;

import it.philmark.docenza.models.Astronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronaveRepository extends JpaRepository<Astronave, Long> {

}
