package com.gestion_prestamos.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.gestion_prestamos.entity.Monto;

public interface MontoRepository extends Repository<Monto, Integer>{
	List<Monto> findAll();
}
