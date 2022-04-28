package it.philmark.docenza.repository;

import it.philmark.docenza.DTO.PianetaDTO;
import it.philmark.docenza.models.Pianeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PieanetaRepository extends JpaRepository<Pianeta, Long> {


    @Query(value = "select * from pianeta where nomePianeta = ?1", nativeQuery = true)
    List<PianetaDTO> getPianetaByName(String nomePianeta);

    @Query(value = "select * from pianeta order by distanzaDallaTerra", nativeQuery = true)
    List<PianetaDTO> getPianetaPiuDistanteDallaTerra(Long distanzaDallaTerra);
}
