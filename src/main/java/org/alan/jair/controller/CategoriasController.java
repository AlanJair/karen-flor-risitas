package org.alan.jair.controller;

import java.util.List;

import org.alan.jair.model.categoria;
import org.alan.jair.model.vacante;
import org.alan.jair.service.CategoriasServiceImp;
import org.alan.jair.service.IntCategoriasService;
import org.alan.jair.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Anotacion @RequestMapping a nivel clase
@RequestMapping(value="/categorias")
public class CategoriasController {
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@RequestMapping(value="/indexPaginate",method=RequestMethod.GET)
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<categoria> lista = serviceCategorias.buscarTodas(page);
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	@RequestMapping(value="/editar",method=RequestMethod.GET)
	public String editar(@RequestParam("id") int idCategoria, Model model) {
		categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategorias";
	}
	
	@RequestMapping(value="/eliminar",method=RequestMethod.GET)
	public String eliminar(@RequestParam("id") int idCategoria, RedirectAttributes attributes) {
		serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "Categoria eliminada.");
		return "redirect:/categorias/indexPaginate";
	}
	
	//Anotacion anterior para solicitar peticiones
	//@GetMapping("/index")
	
	//RequestMapping a nivel del metodo
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<categoria> lista = serviceCategorias.obtenerTodas();
		for(categoria c : lista) {
			System.out.println(c);
		}
		model.addAttribute("categorias", lista);
		return "categorias/listaCategorias";
	}
	
	//@GetMapping("/crear")
	@RequestMapping(value="/crear",method=RequestMethod.GET)
	public String crear(categoria categoria) {
		return "categorias/formCategorias";
	}
	
	@RequestMapping(value="/guardar",method=RequestMethod.POST)
	public String guardar(categoria categoria, RedirectAttributes attributes) {
		//categoria.setId(serviceCategorias.obtenerTodas().size()+1);
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "La categoria de guardo con exito.");
		return "redirect:/categorias/indexPaginate";
	}
	
	/*
	//@PostMapping("/guardar")
	@RequestMapping(value="/guardar",method=RequestMethod.POST)
	//hacer la vinculacion de los elementos de formulario con las variables que reciben los parametros (Data Binding)
	public String guardar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion) {
		System.out.println("Nombre: " + nombre);
		System.out.println("Descripcion: " + descripcion);
		return "categorias/listaCategorias";
	}
	*/
	
}
