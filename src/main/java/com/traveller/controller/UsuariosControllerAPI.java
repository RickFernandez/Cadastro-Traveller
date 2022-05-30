package com.traveller.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event.ID;

import com.traveller.model.Usuarios;
import com.traveller.repository.UsuariosRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosControllerAPI {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@PostMapping
	public Usuarios adicionar(@RequestBody Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@GetMapping
	public List<Usuarios> listar() {
		return usuariosRepository.findAll();
	}
	
	@GetMapping ("/id")
	public ResponseEntity<Usuarios> buscar(@PathVariable ID id) {
		Usuarios usuarios = usuariosRepository.getById(id);
		
		if (usuarios == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuarios> atualizar(@PathVariable ID id, 
			@RequestBody Usuarios usuarios) {
		Usuarios existente = usuariosRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
	
		BeanUtils.copyProperties(usuarios, existente, "id");
		existente = usuariosRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable ID id) {
		Usuarios usuarios = usuariosRepository.getById(id);
		
		if (usuarios == null) {
			return ResponseEntity.notFound().build();
		}
		usuariosRepository.delete(usuarios);
		return ResponseEntity.noContent().build();
	}

}
