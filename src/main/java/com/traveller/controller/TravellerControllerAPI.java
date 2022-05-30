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

import com.traveller.model.NovoLocal;
import com.traveller.repository.TravellerRepository;


@RestController //Faz com que a classe seja motivada pela Web
@RequestMapping("/traveller")
public class TravellerControllerAPI {
	
	//Acorda o Banco de Dados sempre que o controller receber uma chamada da Web
	@Autowired //Faz uma injeção de instância, ou seja, ele faz a instância do objeto automaticamente sem precisar utilizar o 'new'
	private TravellerRepository travellerRepository;
	
	
	//====================== CADASTRO DE LOCAIS ======================
	@GetMapping("/teste")
	public String teste() {
		return "Application is ON";
	}
	
	//Salva as informações recebidas via JSon (body) no BD
	@PostMapping
	public NovoLocal adicionar(@RequestBody NovoLocal novolocal) {
		return travellerRepository.save(novolocal);
	}
	
	//Busca todas as informações do BD e faz um 'findAll'
	@GetMapping
	public List<NovoLocal> listar() {
		return travellerRepository.findAll();
	}
	
	//Busca uma informação no BD através de um 'id' específico, caso não encontre a informação mostrará uma mensagem de ERRO, caso contrário, mortrada a informação
	@GetMapping("/{id}")
	public ResponseEntity<NovoLocal> buscar(@PathVariable Long id) {
		NovoLocal novolocal = travellerRepository.getById(id);
		
		if (novolocal == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(novolocal);
	}
	
	//Faz um update (atualiza) um item do BD
	@PutMapping("/{id}")
	public ResponseEntity<NovoLocal> atualizar(@PathVariable Long id, @RequestBody NovoLocal novoLocal) {
		NovoLocal existente = travellerRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(novoLocal, existente, "id");
		
		existente = travellerRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}
	
	//Deleta um item do BD através do 'id'
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		NovoLocal novolocal = travellerRepository.getById(id);
		
		if (novolocal == null) {
			return ResponseEntity.notFound().build();
		}
		
		travellerRepository.delete(novolocal);
		
		return ResponseEntity.noContent().build();
	}
	
}
