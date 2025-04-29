package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import sistema.reservas.interurbanas.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Integer>, PagingAndSortingRepository<Reserva, Integer>{

}
