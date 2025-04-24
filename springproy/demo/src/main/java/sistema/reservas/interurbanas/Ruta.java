package sistema.reservas.interurbanas;

import java.time.LocalDateTime;
import java.util.List;

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
	private int km;
	
	@OneToMany(mappedBy = "ruta")
    private List<Reserva> reservas;
	
	
}
