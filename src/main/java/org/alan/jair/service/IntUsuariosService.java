package org.alan.jair.service;

import java.util.List;

import org.alan.jair.model.usuario;

public interface IntUsuariosService {
	
	public List<usuario> obtenerTodas();
	public usuario buscarPorId(Integer idUsuario);
	public void guardar(usuario usuario);
	public void eliminar(Integer idUsuario);
}
