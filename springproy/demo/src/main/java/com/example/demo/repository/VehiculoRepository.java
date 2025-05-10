package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.tablas.Vehiculo;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Long>, PagingAndSortingRepository<Vehiculo, Long>{
	
}
