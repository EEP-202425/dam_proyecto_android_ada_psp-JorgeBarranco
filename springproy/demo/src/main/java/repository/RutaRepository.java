package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import sistema.reservas.interurbanas.Ruta;

public interface RutaRepository extends CrudRepository<Ruta, Integer>, PagingAndSortingRepository<Ruta, Integer>{
	
}
