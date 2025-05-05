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
import com.example.demo.tablas.Reserva;
import com.example.demo.tablas.Ruta;
import com.example.demo.tablas.Usuario;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	private final ReservaRepository reservaRepository;
	private final UsuarioRepository usuarioRepository;
	private final RutaRepository rutaRepository;
	
    public ReservaController(ReservaRepository reservaRepo, UsuarioRepository usuarioRepository, RutaRepository rutaRepository) {
        this.reservaRepository = reservaRepo;
        this.usuarioRepository = usuarioRepository;
        this.rutaRepository = rutaRepository;
    }

    @GetMapping
    public Iterable<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
    	
    	Usuario buscarUsuario = usuarioRepository.findByNombre(reserva.getUsuario().getNombre());
    	Ruta rutaCreada = rutaRepository.save(new Ruta(null, reserva.getRuta().getCiudadOrigen(), reserva.getRuta().getCiudadDestino()));
    	
    	Reserva usuarioCreaReserva = new Reserva(null, buscarUsuario, rutaCreada, reserva.getFechaHora(), reserva.getAsiento());
    	
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
