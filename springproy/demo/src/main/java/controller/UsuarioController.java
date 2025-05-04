package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import repository.UsuarioRepository;
import sistema.reservas.interurbanas.Usuario;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
	    return usuarioRepository.findById(id)
	            .map(usuario -> ResponseEntity.ok(usuario))
	            .orElse(ResponseEntity.notFound().build());
	}
	
	
	 @PostMapping
	    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
	        Usuario nuevoUsuario = usuarioRepository.save(usuario);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
	    }
	
}
