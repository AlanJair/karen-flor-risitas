package org.alan.jair.service;

import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.alan.jair.model.categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImp implements IntCategoriasService{
	//variable de clase
		private List<categoria> lista = null;
		
		public CategoriasServiceImp(){
			lista = new LinkedList<categoria>();
			try {
				//primer objeto tipo Categoria
				categoria c1 = new categoria();
				c1.setId(1);
				c1.setNombre("Contabilidad");
				c1.setDescripcion("Relacionado con contabiliad general.");
				lista.add(c1);
				
				//segundo objeto tipo Categoria
				categoria c2 = new categoria();
				c2.setId(2);
				c2.setNombre("Ingenieria");
				c2.setDescripcion("Experiencia en construcciones.");
				lista.add(c2);
				
				//tercer objeto tipo Categoria
				categoria c3 = new categoria();
				c3.setId(3);
				c3.setNombre("Programacion");
				c3.setDescripcion("Desarrollo de aplicaciones web.");
				lista.add(c3);
				
				//cuarto objeto tipo Categoria
				categoria c4 = new categoria();
				c4.setId(4);
				c4.setNombre("Computacion");
				c4.setDescripcion("Relacionado con el mantenimiento de computo.");
				lista.add(c4);
				
			}catch(DateTimeParseException ex){
				System.out.println("Error: "+ex.getMessage());
			}
		}
		@Override
		public List<categoria> obtenerTodas() {
			// TODO Auto-generated method stub
			return lista;
		}
		@Override
		public categoria buscarPorId(Integer idCategoria) {
			// TODO Auto-generated method stub
			for(categoria categoria : obtenerTodas()) {
				if(categoria.getId() == idCategoria) {
					return categoria;
				}
			}
			return null;
		}
		
		@Override
		public void guardar(categoria categoria) {
			// TODO Auto-generated method stub
			lista.add(categoria);

		}
		@Override
		public void eliminar(Integer idCategoria) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Page<categoria> buscarTodas(Pageable page) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
