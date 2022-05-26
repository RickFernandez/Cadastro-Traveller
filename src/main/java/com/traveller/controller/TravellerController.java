package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.NovoLocal;
import com.traveller.repository.TravellerRepository;

@Controller //Indica ao programa que a classe é um Controller
@RequestMapping("/")
public class TravellerController {
	
	@Autowired
	private TravellerRepository travellerRepository; //Acorda o BD neste Controller
	
	@GetMapping("/listaDados")
	public String listaDados(Model request) {
		List<NovoLocal> lista = travellerRepository.findAll(); //Faz uma chamada no BD e carrega as informações dentro da 'lista'
		request.addAttribute("listaDados", lista); //Adiciona os itens da 'lista' no atributo 'listaDados'
		return "listaDados";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@PostMapping("/formularioNovo") //Recebe 'PostMapping' pq este método acorda com um POST da página de formulário (recebe dados de um novo cadastro)
	public String formularioNovo(NovoLocal requisicao) {
		travellerRepository.save(requisicao);
		return "redirect:/listaDados";
	}
}
