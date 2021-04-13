package org.alan.jair.controller;

import java.time.DateTimeException;
import org.alan.jair.model.vacante;
import org.alan.jair.service.IntVacantesService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inicio")
public class HomeController {
	
	@Autowired
	private IntVacantesService serviceVacantes;
	
	@GetMapping("/hola")
	public String mostrarHome(Model model) {
		//Devuelve una vista (Un archivo html)
		List<vacante> vacantes = serviceVacantes.obtenerTodas();
		model.addAttribute("vacantes", vacantes);
		return "home";
	}
	
	@GetMapping("/mensaje")
	public String mensaje(Model model) {
		//formatear una fecha 
		//LocalDate fecha = LocalDate.now();
		LocalDate fecha= null;
		try {
			fecha = LocalDate.parse("23-12-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			System.out.println("Fecha: " + fecha);
		}catch(DateTimeException ex) {
			System.out.println("Error : " + ex.getMessage());
		}

		model.addAttribute("msg", "Hola Mundo");
		//actualmente thymeleaf no soporta localDate, por tanto convertirlo a Date
		model.addAttribute("fecha", java.sql.Date.valueOf(fecha));
		return "mensaje";
	}
	//Nuevo metodo 
	
	@GetMapping("/vacante")
	public String vacante(Model model) {
		Integer id = 1000;
		String nombre = "Programador de Aplicaciones web";
		LocalDate fecha = LocalDate.now();
		Double  salario= 12500.00;
		Boolean vigente = true;
		model.addAttribute("id", id);
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fecha);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		return "vacante";
	}
	
	//Una coleccion de datos 
	@GetMapping("/lista")
	public String lista(Model model) {
		List<String> vacantes = new LinkedList<String>();
		vacantes.add("Contador Publico");
		vacantes.add("Programador de Aplicaciones");
		vacantes.add("Tecnico de Mantenimiento de Computo");
		vacantes.add("Arquitecto");
		vacantes.add("Ingeniero en Electronica");
		//Impimir el areglo 
		for(String elemento : vacantes) {
			System.out.println(elemento);
		}
		model.addAttribute("vacantes",vacantes);
		return "vacante";	
	}
	
	@GetMapping("/detalles")
	public String detalles(Model model) {
		vacante v = new vacante();
		System.out.println(v);
		v.setId(100);
		v.setNombre("Ingeniero Electronico");		
		v.setDescripcion("Relaciona con aplicaciones para IOT");		
		v.setFecha(LocalDate.now());
		v.setSalario(12800.0);
		System.out.println(v);
		model.addAttribute("vacante", v);
		
		return "detalles";
	}
	
	@GetMapping("/tabla")
	public String mostrarVacantes(Model model) {
		List<vacante> vacantes = serviceVacantes.obtenerTodas();
		for(vacante elemento: vacantes) {
			System.out.println(elemento.getId());
			System.out.println(elemento.getNombre());
			System.out.println(elemento.getDescripcion());
			System.out.println(elemento.getFecha());
			System.out.println(elemento.getSalario());
			System.out.println(elemento.getDestacado());
		}
		model.addAttribute("vacantes", vacantes);
		return "tabla";
	}
	
}