package com.example.promocion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.promocion.entity.Votos;

@Repository
public interface VotoRepository extends JpaRepository<Votos, Long> {
	Optional<Votos> findBynombreVotante(String np);
    boolean existsBynombreVotante(String np);
}