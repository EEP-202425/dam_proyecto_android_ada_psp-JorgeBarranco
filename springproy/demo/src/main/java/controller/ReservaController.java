package controller;


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

import repository.ReservaRepository;
import sistema.reservas.interurbanas.Reserva;

@RestController
@RequestMapping("reservas")
public class ReservaController {

	private final ReservaRepository reservaRepo;
	
    public ReservaController(ReservaRepository reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    @GetMapping
    public Iterable<Reserva> listar() {
        return reservaRepo.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaRepo.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Long id, @RequestBody Reserva r) {
    	Reserva reserva = reservaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));
        reserva.setFechaHora(r.getFechaHora());
        reserva.setRuta(r.getRuta());
        reserva.setAsiento(r.getAsiento());
        return reservaRepo.save(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
    	reservaRepo.deleteById(id);
    }
}
