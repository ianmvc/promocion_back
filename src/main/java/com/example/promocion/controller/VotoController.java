package com.example.promocion.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.promocion.DTO.Mensaje;
import com.example.promocion.entity.Votos;
import com.example.promocion.service.VotoService;

@RestController
@CrossOrigin(origins = "https://app.marianovqz.com")
@RequestMapping("/api/votacion")
public class VotoController {
	@Autowired
    VotoService votoService;
	
	@PostMapping("nuevo")
    public ResponseEntity<?> create(@RequestBody Votos votos){
        if(StringUtils.isBlank(votos.getNombreVotante()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(votoService.existePorNombre(votos.getNombreVotante()))
            return new ResponseEntity(new Mensaje("Ese votante ya existe"), HttpStatus.BAD_REQUEST);

        votoService.guardar(votos);
        return new ResponseEntity(new Mensaje("Votante registrado"), HttpStatus.CREATED);
    }
}
