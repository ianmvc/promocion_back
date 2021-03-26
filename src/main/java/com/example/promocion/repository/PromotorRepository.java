package com.example.promocion.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.promocion.entity.votante;

@Repository
public interface PromotorRepository extends JpaRepository<votante, Serializable> {
	@Query(value = "SELECT * FROM votante WHERE usuario = ?1", nativeQuery = true)
	public abstract List<votante> findByPromotor(String promotor);
}
