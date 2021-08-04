package com.projetointegradorgrupo3.ProjetoReintegrar.controller;

import java.util.List;

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

import com.projetointegradorgrupo3.ProjetoReintegrar.model.Categoria;
import com.projetointegradorgrupo3.ProjetoReintegrar.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria") //vai esta na URL.
@CrossOrigin("*")

public class CategoriaController {
	@Autowired 
	private CategoriaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	//pathvariable vai buscar o id na url
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>findById( @PathVariable long id ){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/setor/{setor}")
	public ResponseEntity<List <Categoria>>findBySetor(@PathVariable String setor){
		return ResponseEntity.ok(repository.findAllBySetorContainingIgnoreCase(setor));
	}
	
	@GetMapping("/cargo/{cargo}")
	public ResponseEntity<List <Categoria>>findByCargo(@PathVariable String cargo){
		return ResponseEntity.ok(repository.findAllByCargoContainingIgnoreCase(cargo));
	
	}
	
	@PostMapping
	public ResponseEntity<Categoria>post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria>put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}

