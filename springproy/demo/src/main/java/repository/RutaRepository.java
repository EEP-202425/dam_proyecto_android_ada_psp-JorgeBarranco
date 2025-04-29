package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import sistema.reservas.interurbanas.Ruta;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Long>, PagingAndSortingRepository<Ruta, Long>{
	
}
