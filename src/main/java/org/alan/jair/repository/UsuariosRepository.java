package org.alan.jair.repository;

import org.alan.jair.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuariosRepository extends JpaRepository<usuario, Integer> {

}
