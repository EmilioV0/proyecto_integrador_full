package com.gestion_prestamos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion_prestamos.entity.prestamos;
import com.gestion_prestamos.repository.PrestamoRepository;

@Service
public class PrestamosServiceImp implements PrestamosService {
	@Autowired
	private PrestamoRepository prestamoRepo;

	@Override
	public List<prestamos> findAll() {
		
		return (List<prestamos>) prestamoRepo.findAll();
	}

	@Override
	public prestamos findById(Integer id) {
		return prestamoRepo.findById(id).orElse(null);
	}

	@Override
	public prestamos save(prestamos prestamo) {
		return prestamoRepo.save(prestamo);
	}

	@Override
	public void delete(Integer id) {
		prestamoRepo.deleteById(id);
		
	}
	
	
	
}
