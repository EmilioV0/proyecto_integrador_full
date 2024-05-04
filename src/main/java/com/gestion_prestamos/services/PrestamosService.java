package com.gestion_prestamos.services;

import java.util.List;

import com.gestion_prestamos.entity.prestamos;
public interface PrestamosService {
	public List<prestamos> findAll();
	public prestamos findById(Integer id);
	public prestamos save(prestamos prestamo);
	public void delete(Integer id);
}
