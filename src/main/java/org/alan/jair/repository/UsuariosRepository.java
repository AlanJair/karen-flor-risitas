package org.alan.jair.repository;

import org.alan.jair.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
