package org.alan.jair.repository;

import java.util.List;

import org.alan.jair.model.vacante;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;



public interface VacantesRepository extends JpaRepository<vacante, Integer> {
	
	public List<vacante> findByEstatus(String estatus);
	public List<vacante> findByEstatusAndDestacado(String estatus, Integer destacado);
}
