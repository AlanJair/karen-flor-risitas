package org.alan.jair.service.db;

import java.util.List;
import java.util.Optional;

import org.alan.jair.model.categoria;
import org.alan.jair.repository.CategoriasRepository;
import org.alan.jair.service.IntCategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CategoriasServiceJpa implements IntCategoriasService {
	
	@Autowired
	private CategoriasRepository repoCategorias;

	@Override
	public List<categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoCategorias.findAll();
	}
	
	@Override
	public categoria buscarPorId(Integer idCategoria) {
		Optional<categoria> optional = repoCategorias.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(categoria categoria) {
		// TODO Auto-generated method stub
		repoCategorias.save(categoria);
	}
	
	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		repoCategorias.deleteById(idCategoria);
	}
	
	@Override
	public Page<categoria> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoCategorias.findAll(page);
	}

}
