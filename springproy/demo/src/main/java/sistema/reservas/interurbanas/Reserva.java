package sistema.reservas.interurbanas;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    private Usuario usuario;
	
	@ManyToOne
    private Ruta ruta;
	
	private LocalDateTime fechaHora;
    private int asiento;

}
