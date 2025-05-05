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
import com.example.demo.tablas.Reserva;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	private final ReservaRepository reservaRepository;
	
    public ReservaController(ReservaRepository reservaRepo) {
        this.reservaRepository = reservaRepo;
    }

    @GetMapping
    public Iterable<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaRepository.save(reserva);
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
