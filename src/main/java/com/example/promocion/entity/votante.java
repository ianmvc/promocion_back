package com.example.promocion.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votante")
public class votante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String nombreVotante;

	@NotNull
	private String domicilio;
	
	@NotNull
	private String telcel;
	
	@NotNull
	private String telcasa;
	
	@NotNull
	private String seccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreVotante() {
		return nombreVotante;
	}

	public void setNombreVotante(String nombreVotante) {
		this.nombreVotante = nombreVotante;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getTelcel() {
		return telcel;
	}

	public void setTelcel(String telcel) {
		this.telcel = telcel;
	}
	
	public String getTelcasa() {
		return telcasa;
	}

	public void setTelcasa(String telcasa) {
		this.telcasa = telcasa;
	}
	
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
}
