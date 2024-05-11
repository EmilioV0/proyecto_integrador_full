package com.gestion_prestamos.services;

import java.util.List;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO;
import com.gestion_prestamos.entity.SolicitudPrestamo;
import com.gestion_prestamos.entity.User;

public interface SolicitudPrestamoService {
	public List<SolicitudPrestamo> findAll();
	public SolicitudPrestamo findById(Integer id);
	public SolicitudPrestamo save(CrearPrestamoDTO prestamo, User user);
	public void delete(Integer id);
	public List<SolicitudPrestamoResumenDTO> buscarTodosPorPrestatario(int idPrestatario);
	List<SolicitudPrestamoPrestatarioDTO> buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(
																	String fechaDeInicio,
																	String fechaDeFin,
																	String text,
																	int idPrestamista
																);
}
