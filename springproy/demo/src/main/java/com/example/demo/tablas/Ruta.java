package com.example.demo.tablas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutas")
public class Ruta {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String ciudadOrigen;
	private String ciudadDestino;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ruta")
    private List<Reserva> reservas;
	
	public Ruta(Long id, String ciudadOrigen, String ciudadDestino) {
		this.id = id;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}
