package com.example.promocion.entity;

import java.util.HashSet;
import java.util.Set;

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

	@NotNull
	private String fecha_agregado;
	
	private boolean validado;
	
	private String fecha_validado;
	
	private String colonia;
	
	private String comentarios;
	
	private String instragram;
	
	private String facebook;
	
	private String red_social;

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
	
	public boolean getValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}
	
	public String getFecha_agregado() {
		return fecha_agregado;
	}

	public void setFecha_agregado(String fecha_agregado) {
		this.fecha_agregado = fecha_agregado;
	}
	
	public String getFecha_validado() {
		return fecha_validado;
	}

	public void setFecha_validado(String fecha_validado) {
		this.fecha_validado = fecha_validado;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getInstragram() {
		return instragram;
	}

	public void setInstragram(String instragram) {
		this.instragram = instragram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getRed_social() {
		return red_social;
	}

	public void setRed_social(String red_social) {
		this.red_social = red_social;
	}
	
}
