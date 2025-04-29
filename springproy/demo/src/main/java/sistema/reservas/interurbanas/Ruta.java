package sistema.reservas.interurbanas;

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
	
	public Ruta(Long id, String ciudadOrigen, String ciudadDestino, int km) {
		this.id = id;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.km = km;
	}
}
