package com.gestion_prestamos.services;

import org.springframework.stereotype.Service;

import com.gestion_prestamos.repository.InteresRepostory;
import com.gestion_prestamos.repository.TiempoRepository;

@Service
public class InteresServiceImpl implements InteresService{

	private final InteresRepostory interesRepo;
	private final TiempoRepository tiempoRepo;

	public InteresServiceImpl(InteresRepostory interesRepo, TiempoRepository tiempoRepo) {
		this.interesRepo = interesRepo;
		this.tiempoRepo = tiempoRepo;
	}

	@Override
	public String[][] getIntereses() {
		String[] intereses = interesRepo.getIntereses();
		String[] duracion = tiempoRepo.findAll();
		String[][] table = new String[5][6];

		for ( int i = 0; i < duracion.length; i++ ) {
			String diasPago = duracion[i] + " días,";
			String interesesPorDiasPago = diasPago + intereses[i];
			table[i] = interesesPorDiasPago.split(",");
		}

		return table;
	}



}
