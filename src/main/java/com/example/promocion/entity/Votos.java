package com.example.promocion.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votos")

public class Votos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String nombreVotante;
	
	@NotNull
	private String seccion;
	
	private boolean registrado;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public boolean isVoto() {
		return registrado;
	}

	public void setVoto(boolean registrado) {
		this.registrado = registrado;
	}
}
