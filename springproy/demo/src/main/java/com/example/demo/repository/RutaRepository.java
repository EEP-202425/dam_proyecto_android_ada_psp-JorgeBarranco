package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.tablas.Ruta;

@Repository
public interface RutaRepository extends CrudRepository<Ruta, Long>, PagingAndSortingRepository<Ruta, Long>{
	
}
