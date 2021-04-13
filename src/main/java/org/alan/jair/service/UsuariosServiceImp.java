package org.alan.jair.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.alan.jair.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImp implements IntUsuariosService {
	
	//variable de clase
	private List<Usuario> lista = null;
	
	public UsuariosServiceImp(){
		lista = new LinkedList<Usuario>(); 
		try {
			//primer objeto tipo Usuario
			Usuario u1 = new Usuario();
			u1.setId(1);
			u1.setNombre("Natalia");
			u1.setUsername("natalia10");
			u1.setEmail("natalia@gmail.com");
			u1.setPassword("123456");
			u1.setFechaRegistro(LocalDate.parse("07-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			u1.setEstatus(1);
			//u1.setImagen("contador.png");
			lista.add(u1);
			
			//segundo objeto tipo Usuario
			Usuario u2 = new Usuario();
			u2.setId(2);
			u2.setNombre("Armando");
			u2.setUsername("natalia10");
			u2.setEmail("armando@gmail.com");
			u2.setPassword("123456");
			u2.setFechaRegistro(LocalDate.parse("07-02-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			u2.setEstatus(1);
			//u1.setImagen("contador.png");
			lista.add(u2);
			
			//tercer objeto tipo Usuario
			Usuario u3 = new Usuario();
			u3.setId(3);
			u3.setNombre("Antonio");
			u3.setUsername("antonio50");
			u3.setEmail("antonio@gmail.com");
			u3.setPassword("123456");
			u3.setFechaRegistro(LocalDate.parse("18-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			u3.setEstatus(0);
			//u3.setImagen("contador.png");
			lista.add(u3);
			
			//cuarto objeto tipo Usuario
			Usuario u4 = new Usuario();
			u4.setId(4);
			u4.setNombre("Jair");
			u4.setUsername("jair777");
			u4.setEmail("jair@gmail.com");
			u4.setPassword("123456");
			u4.setFechaRegistro(LocalDate.parse("27-01-2021",DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			u4.setEstatus(1);
			//u4.setImagen("contador.png");
			lista.add(u4);
			
		}catch(DateTimeParseException ex){
			System.out.println("Error: "+ex.getMessage());
		}
	}
	
	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		for(Usuario usuario : lista) {
			if(usuario.getId() == idUsuario) {
				return usuario;
			}	
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		lista.add(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		//lista.remove(idUsuario);

	}

}
