package com.example.promocion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.promocion.entity.Votos;
import com.example.promocion.repository.VotoRepository;

@Service
@Transactional
public class VotoService {
	@Autowired
	VotoRepository votoRepository;
	
	public List<Votos> obtenerTodos(){
        List<Votos> lista = votoRepository.findAll();
        return lista;
    }
	
	public Optional<Votos> obtenerPorNombre(String np){
        return votoRepository.findByNombreVoto(np);
    }
	
	public void guardar(Votos votos){
		votoRepository.save(votos);
    }
	
	public boolean existePorNombre(String np){
        return votoRepository.existsByNombreVoto(np);
    }
}
