package com.gestion_prestamos.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO;
import com.gestion_prestamos.entity.SolicitudPrestamo;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.mapper.PrestamoMapper;
import com.gestion_prestamos.repository.SolicitudPrestamoRepository;

@Service
public class SolicitudPrestamoServiceImp implements SolicitudPrestamoService {
	@Autowired
	private SolicitudPrestamoRepository solicitudPrestamoRepo;

	@Override
	public List<SolicitudPrestamo> findAll() {

		return solicitudPrestamoRepo.findAll();
	}

	@Override
	public SolicitudPrestamo findById(Integer id) {
		return solicitudPrestamoRepo.findById(id).orElse(null);
	}

	@Override
	public SolicitudPrestamo save(CrearPrestamoDTO prestamo, User user) {
		SolicitudPrestamo nuevoPrestamo = PrestamoMapper.toPrestamo(prestamo, user);
		return solicitudPrestamoRepo.save(nuevoPrestamo);
	}

	@Override
	public void delete(Integer id) {
		solicitudPrestamoRepo.deleteById(id);
	}

	@Override
	public List<SolicitudPrestamoResumenDTO> buscarTodosPorPrestatario(int idPrestatario) {
		return solicitudPrestamoRepo.buscarTodosPorPrestatario(idPrestatario);
	}
	
	@Override
	public List<SolicitudPrestamoPrestatarioDTO> buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(
			String fechaDeInicio,
			String fechaDeFin,
			String text,
			int idPrestamista
		) {
		
		LocalDateTime begin = LocalDate.parse(fechaDeInicio).atStartOfDay();
		LocalDateTime end = LocalDate.parse(fechaDeFin).atStartOfDay();
		System.out.println( idPrestamista );
		System.out.println( fechaDeInicio );
		System.out.println( fechaDeFin );
		
		return solicitudPrestamoRepo.buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(begin, end, text, idPrestamista);
	}
}
