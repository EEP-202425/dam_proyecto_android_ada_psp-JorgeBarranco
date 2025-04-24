package sistema.reservas.interurbanas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nombre;
	    private String email;
	    
	    @JsonIgnore
	    private String password;

	    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	    private List<Reserva> reservas;
	    
	    public Usuario(Long id, String nombre, String email, String password) {
	    	this.id = id;
	    	this.nombre = nombre;
	    	this.email = email;
	    	this.password = password;
	    }
}
