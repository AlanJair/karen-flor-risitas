package org.alan.jair.service;

import java.util.List;

import org.alan.jair.model.categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntCategoriasService {
	
	public List<categoria> obtenerTodas();
	public categoria buscarPorId(Integer idCategoria);
	public void guardar(categoria categoria);
	public void eliminar(Integer idCategoria);
	public Page<categoria>buscarTodas(Pageable page);
}
