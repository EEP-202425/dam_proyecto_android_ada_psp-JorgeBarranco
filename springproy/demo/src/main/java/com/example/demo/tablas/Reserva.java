package com.example.demo.tablas;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Ruta ruta;
	
	private String fechaHora;
	
    private int asiento;
    
    public Reserva() {
    	
    }
    
    public Reserva(Long id, Ruta ruta,Vehiculo vehiculo, String fechaHora, int asiento) {
    	this.id = id;
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
	
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
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
