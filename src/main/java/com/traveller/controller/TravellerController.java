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
	
	@GetMapping("/listaLocais")
	public String listaDados(Model request) {
		List<NovoLocal> lista = travellerRepository.findAll(); //Faz uma chamada no BD e carrega as informações dentro da 'lista'
		request.addAttribute("listaLocais", lista); //Adiciona os itens da 'lista' no atributo 'listaDados'
		return "listaLocais";
	}
	
	@GetMapping("/cadastroLocal")
	public String cadastroLocal() {
		return "cadastroLocal";
	}
	
	@PostMapping("/localNovo") //Recebe 'PostMapping' pq este método acorda com um POST da página de formulário (recebe dados de um novo cadastro)
	public String localNovo(NovoLocal requisicao) {
		travellerRepository.save(requisicao);
		return "redirect:/listaLocais";
	}
	
	//========== NAVEGAÇÃO DE PÁGINAS HTML==========
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hospedagem")
	public String hospedagem() {
		return "ondeHospedar";
	}
	
	@GetMapping("/parques")
	public String parques() {
		return "parques";
	}
	
	@GetMapping("/gastronomia")
	public String gastronomia() {
		return "gastronomia";
	}
	
	@GetMapping("/erro")
	public String vidaNoturna() {
		return "erro";
	}
	
	@GetMapping("/pageTemplate")
	public String pageTemplate() {
		return "pagetemplate";
	}
	
} 
