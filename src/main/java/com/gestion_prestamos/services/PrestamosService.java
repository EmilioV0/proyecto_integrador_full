package com.gestion_prestamos.services;

import java.util.List;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.dto.PrestamoResumenDTO;
import com.gestion_prestamos.entity.Prestamo;
import com.gestion_prestamos.entity.User;

public interface PrestamosService {
	public List<Prestamo> findAll();
	public Prestamo findById(Integer id);
	public Prestamo save(CrearPrestamoDTO prestamo, User user);
	public void delete(Integer id);
	public List<PrestamoResumenDTO> buscarTodosPorPrestatario(int idPrestatario);
}
