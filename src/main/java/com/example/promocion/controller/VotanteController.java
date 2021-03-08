package com.example.promocion.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.promocion.DTO.Mensaje;
import com.example.promocion.entity.votante;
import com.example.promocion.service.VotanteService;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/promocion")
public class VotanteController {
	@Autowired
    VotanteService votanteService;

    @GetMapping("lista")
    public ResponseEntity<List<votante>> getLista(){
        List<votante> lista = votanteService.obtenerTodos();
        return new ResponseEntity<List<votante>>(lista, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<votante> getOne(@PathVariable Long id){
        if(!votanteService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese Votante"), HttpStatus.NOT_FOUND);
        votante producto = votanteService.obtenerPorId(id).get();
        return new ResponseEntity<votante>(producto, HttpStatus.OK);
    }

    @PostMapping("nuevo")
    public ResponseEntity<?> create(@RequestBody votante votante){
        if(StringUtils.isBlank(votante.getNombreVotante()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getDomicilio()))
            return new ResponseEntity(new Mensaje("El domicilio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getTelcel() ))
            return new ResponseEntity(new Mensaje("El celular es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getTelcasa() ))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getSeccion() ))
            return new ResponseEntity(new Mensaje("La sección es obligatoria"), HttpStatus.BAD_REQUEST);
        if(votanteService.existePorNombre(votante.getNombreVotante()))
            return new ResponseEntity(new Mensaje("Ese votante ya existe"), HttpStatus.BAD_REQUEST);
        votanteService.guardar(votante);
        return new ResponseEntity(new Mensaje("Votante registrado"), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody votante votante, @PathVariable("id") Long id){
        if(!votanteService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese producto"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(votante.getNombreVotante()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getDomicilio()))
            return new ResponseEntity(new Mensaje("El domicilio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getTelcel() ))
            return new ResponseEntity(new Mensaje("El celular es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getTelcasa() ))
            return new ResponseEntity(new Mensaje("El telefono es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(votante.getSeccion() ))
            return new ResponseEntity(new Mensaje("La sección es obligatoria"), HttpStatus.BAD_REQUEST);
        if(votanteService.existePorNombre(votante.getNombreVotante()) &&
        		votanteService.obtenerPorNombre(votante.getNombreVotante()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese votante ya existe"), HttpStatus.BAD_REQUEST);
        votante prodUpdate = votanteService.obtenerPorId(id).get();
        prodUpdate.setNombreVotante(votante.getNombreVotante());
        prodUpdate.setDomicilio(votante.getDomicilio());
        prodUpdate.setTelcel(votante.getTelcel());
        prodUpdate.setTelcasa(votante.getTelcasa());
        prodUpdate.setSeccion(votante.getSeccion());
        prodUpdate.setValidado(votante.getValidado());
        prodUpdate.setFecha_agregado(votante.getFecha_agregado());
        prodUpdate.setFecha_validado(votante.getFecha_validado());
        votanteService.guardar(prodUpdate);
        return new ResponseEntity(new Mensaje("Información de votante actualizada"), HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(!votanteService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe ese votante"), HttpStatus.NOT_FOUND);
        votanteService.borrar(id);
        return new ResponseEntity(new Mensaje("Votante eliminado con éxito"), HttpStatus.OK);
    }
}
