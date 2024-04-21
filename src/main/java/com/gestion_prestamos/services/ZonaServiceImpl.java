package com.gestion_prestamos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion_prestamos.entity.Zona;
import com.gestion_prestamos.repository.ZonaRepository;

@Service
public class ZonaServiceImpl implements ZonaService {

	private final ZonaRepository zonaRepository;
	
	public ZonaServiceImpl(ZonaRepository zonaRepository) {
		this.zonaRepository = zonaRepository;
	}

	@Override
	public List<Zona> findAll() {
		return zonaRepository.findAll();
	}

}
