package it.philmark.docenza.repository;

import java.util.Optional;

import it.philmark.docenza.models.ERole;
import it.philmark.docenza.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);

}
