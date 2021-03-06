package com.example.promocion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.promocion.entity.votante;
import com.example.promocion.repository.VotanteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VotanteService {
	  @Autowired
	  VotanteRepository votanteRepository;

	    public List<votante> obtenerTodos(){
	        List<votante> lista = votanteRepository.findAll();
	        return lista;
	    }

	    public Optional<votante> obtenerPorId(Long id){
	        return votanteRepository.findById(id);
	    }

	    public Optional<votante> obtenerPorNombre(String np){
	        return votanteRepository.findByNombreVotante(np);
	    }

	    public void guardar(votante votante){
	    	votanteRepository.save(votante);
	    }

	    public void borrar(Long id){
	    	votanteRepository.deleteById(id);
	    }

	    public boolean existePorNombre(String np){
	        return votanteRepository.existsByNombreVotante(np);
	    }

	    public boolean existePorId(Long id){
	        return votanteRepository.existsById(id);
	    }
}
