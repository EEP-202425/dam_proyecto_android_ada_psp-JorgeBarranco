package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.RutaRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.tablas.Reserva;
import com.example.demo.tablas.Ruta;
import com.example.demo.tablas.Usuario;
import com.example.demo.tablas.Vehiculo;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	private final ReservaRepository reservaRepository;
	private final UsuarioRepository usuarioRepository;
	private final RutaRepository rutaRepository;
	private final VehiculoRepository vehiculoRepository;
	
    public ReservaController(ReservaRepository reservaRepo, UsuarioRepository usuarioRepository, RutaRepository rutaRepository,
    		VehiculoRepository vehiculoRepository) {
        this.reservaRepository = reservaRepo;
        this.usuarioRepository = usuarioRepository;
        this.rutaRepository = rutaRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @GetMapping
    public Iterable<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
    	
    	Ruta rutaCreada = rutaRepository.save(new Ruta(null, reserva.getRuta().getCiudadOrigen(), reserva.getRuta().getCiudadDestino()));
    	Vehiculo vehiculoElegido = vehiculoRepository.save(new Vehiculo(null, reserva.getVehiculo().getMatricula(), reserva.getVehiculo().getTipo(), reserva.getVehiculo()
    			.getCapacidad()));
    	
    	
    	Reserva usuarioCreaReserva = new Reserva(null, rutaCreada, vehiculoElegido, reserva.getFechaHora(), reserva.getAsiento());
    	
    	
        Reserva nuevaReserva = reservaRepository.save(usuarioCreaReserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Long id, @RequestBody Reserva r) {
    	Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));
        reserva.setFechaHora(r.getFechaHora());
        reserva.setRuta(r.getRuta());
        reserva.setAsiento(r.getAsiento());
        return reservaRepository.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
    	reservaRepository.deleteById(id);
    }
}
