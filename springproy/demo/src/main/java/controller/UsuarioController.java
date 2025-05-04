package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import repository.UsuarioRepository;
import sistema.reservas.interurbanas.Usuario;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	 @PostMapping
	    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
	        Usuario nuevoUsuario = usuarioRepository.save(usuario);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
	    }
	
}
