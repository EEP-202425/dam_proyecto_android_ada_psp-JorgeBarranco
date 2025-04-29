package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import repository.ReservaRepository;
import sistema.reservas.interurbanas.Reserva;

public class ReservaService {
	
	private final ReservaRepository reservaRepo;

    public ReservaService(ReservaRepository reservaRepo) {
        this.reservaRepo = reservaRepo;
    }

    public List<Reserva> listar() {
        return reservaRepo.findAll();
    }

    public Reserva crear(Reserva reserva) {
        return reservaRepo.save(reserva);
    }

    public Reserva actualizar(Long id, Reserva r) {
        Reserva reserva = reservaRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrada"));
        reserva.setFechaHora(r.getFechaHora());
        reserva.setRuta(r.getRuta());
        reserva.setAsiento(r.getAsiento());
        return reservaRepo.save(reserva);
    }

    public void eliminar(Long id) {
        reservaRepo.deleteById(id);
    }
}
