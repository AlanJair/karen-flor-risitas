package org.alan.jair.repository;

import org.alan.jair.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;



//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {}

public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{
	
}
