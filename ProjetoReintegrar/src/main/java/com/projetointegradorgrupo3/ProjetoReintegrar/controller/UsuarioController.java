package com.projetointegradorgrupo3.ProjetoReintegrar.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegradorgrupo3.ProjetoReintegrar.model.Usuario;
import com.projetointegradorgrupo3.ProjetoReintegrar.repository.UsuarioRepository;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin ("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id){
		return repository.findById(id).map(usuario -> ResponseEntity.ok(usuario))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/{nome}")
	public ResponseEntity<List<Usuario>> findByNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping ("/email/{email}")
	public ResponseEntity<List<Usuario>> findByEmail (@PathVariable String email){
		return ResponseEntity.ok(repository.findAllByEmailContainingIgnoreCase(email));
		
	}
	@GetMapping ("/genero/{genero}")
	public ResponseEntity<List<Usuario>> findByGenero (@PathVariable String genero){
		return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario (@RequestBody @Valid Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> putUsuario (@RequestBody @Valid Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping ("/{id}")
	public void deleteById (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
