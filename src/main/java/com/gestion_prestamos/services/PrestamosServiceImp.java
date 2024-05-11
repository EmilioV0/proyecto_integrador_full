package com.gestion_prestamos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.dto.PrestamoResumenDTO;
import com.gestion_prestamos.entity.Prestamo;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.mapper.PrestamoMapper;
import com.gestion_prestamos.repository.PrestamoRepository;

@Service
public class PrestamosServiceImp implements PrestamosService {
	@Autowired
	private PrestamoRepository prestamoRepo;

	@Override
	public List<Prestamo> findAll() {

		return prestamoRepo.findAll();
	}

	@Override
	public Prestamo findById(Integer id) {
		return prestamoRepo.findById(id).orElse(null);
	}

	@Override
	public Prestamo save(CrearPrestamoDTO prestamo, User user) {
		Prestamo nuevoPrestamo = PrestamoMapper.toPrestamo(prestamo, user);
		return prestamoRepo.save(nuevoPrestamo);
	}

	@Override
	public void delete(Integer id) {
		prestamoRepo.deleteById(id);
	}

	@Override
	public List<PrestamoResumenDTO> buscarTodosPorPrestatario(int idPrestatario) {
		return prestamoRepo.buscarTodosPorPrestatario(idPrestatario);
	}


}
