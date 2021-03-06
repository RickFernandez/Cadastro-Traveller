package com.traveller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.traveller.model.Usuarios;
import com.traveller.repository.UsuariosRepository;

@Controller
@RequestMapping("/")
public class UsuariosController {
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping("cadastroUsuario")
	public String cadastroUsuario() {
		return "cadastroUsuario";
	}
	
	@PostMapping("/usuarioNovo")
	public String usuarioNovo(Usuarios requisicao) {
		usuariosRepository.save(requisicao);
		return "redirect:/listaUsuarios";
	}
	
	
	@GetMapping("/listaUsuarios")
	public String listaUsuarios(Model request) {
		List<Usuarios> lista = usuariosRepository.findAll();
		request.addAttribute("listaUsuarios", lista);
		return "listaUsuarios";
	}
}
