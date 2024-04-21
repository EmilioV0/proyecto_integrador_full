package com.gestion_prestamos.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.gestion_prestamos.entity.Zona;

public interface ZonaRepository extends Repository<Zona, Integer>{
	List<Zona> findAll();
}
