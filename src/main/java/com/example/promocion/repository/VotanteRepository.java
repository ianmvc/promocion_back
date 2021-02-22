package com.example.promocion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.promocion.entity.votante;

import java.util.Optional;

@Repository
public interface VotanteRepository extends JpaRepository<votante, Long>{
	Optional<votante> findByNombreVotante(String np);
    boolean existsByNombreVotante(String np);
}
