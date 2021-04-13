package org.alan.jair.controller;

import java.util.List;

import org.alan.jair.model.usuario;
import org.alan.jair.service.IntUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<usuario> lista= usuariosService.obtenerTodas();
		for(usuario u: lista) {
			System.out.println(u);
		}
		model.addAttribute("usuarios", lista);
		return "usuarios/listaUsuarios";
	}
	
}
