package org.alan.jair.service;

import java.util.List;

import org.alan.jair.model.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerTodas();
	public Usuario buscarPorId(Integer idUsuario);
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);
}
