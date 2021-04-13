package org.alan.jair.service.db;

import java.util.List;
import java.util.Optional;

import org.alan.jair.model.vacante;
import org.alan.jair.repository.VacantesRepository;
import org.alan.jair.service.IntVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService {
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	@Override
	public List<vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoVacantes.findAll();
	}

	@Override
	public vacante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<vacante> optional = repoVacantes.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(vacante vacante) {
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer id) {
		repoVacantes.deleteById(id);
	}

	@Override
	public Page<vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return repoVacantes.findAll(page);
	}

}
