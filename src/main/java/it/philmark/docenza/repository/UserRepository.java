package it.philmark.docenza.repository;

import java.util.List;
import java.util.Optional;

import it.philmark.docenza.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Boolean existsByEmail(String email);

	@Query(value = "select * from users", nativeQuery = true)
	List<User> getAllUsers();

    Optional<User> findByEmail(String email);

}