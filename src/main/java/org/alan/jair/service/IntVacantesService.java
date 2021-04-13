package org.alan.jair.service;

import java.util.List;

import org.alan.jair.model.vacante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IntVacantesService {
	//metodos abstractos
	public List<vacante> obtenerTodas();
	public vacante buscarPorId(Integer id);
	public void guardar(vacante vacante);
	public void eliminar(Integer id);
	public Page<vacante>buscarTodas(Pageable page);
}
