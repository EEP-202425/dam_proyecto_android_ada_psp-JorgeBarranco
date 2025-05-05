package com.example.demo.tablas;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Ruta ruta;
	
	private LocalDateTime fechaHora;
    private int asiento;
    
    public Reserva(Long id, Usuario usuario, Ruta ruta, Vehiculo vehiculo, LocalDateTime fechaHora, int asiento) {
    	this.id = id;
    	this.usuario = usuario;
    	this.ruta = ruta;
    	this.vehiculo = vehiculo;
    	this.fechaHora = fechaHora;
    	this.asiento = asiento;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public int getAsiento() {
		return asiento;
	}
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
