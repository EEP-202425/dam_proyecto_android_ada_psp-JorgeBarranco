package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.tablas.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Long>, PagingAndSortingRepository<Reserva, Long>{
//	List<Reserva> findByUsuarioId(Long usuarioId);
}
