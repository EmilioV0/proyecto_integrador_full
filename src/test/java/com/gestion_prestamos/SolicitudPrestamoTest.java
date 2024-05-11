package com.gestion_prestamos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO;
import com.gestion_prestamos.repository.SolicitudPrestamoRepository;

@SpringBootTest
public class SolicitudPrestamoTest {

	@Autowired
	private SolicitudPrestamoRepository repo;
	
	public SolicitudPrestamoTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas() {
		LocalDate fechaDeInicio = LocalDate.parse("2024-05-04");
        LocalDate fechaDeFin = LocalDate.parse("2024-06-16");
        
        // Convertir LocalDate a LocalDateTime estableciendo la hora y los minutos en 0
        LocalDateTime fechaDeInicioConHoraCero = fechaDeInicio.atStartOfDay();
        LocalDateTime fechaDeFinConHoraCero = fechaDeFin.atStartOfDay();
		
        repo.
        buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(fechaDeInicioConHoraCero, fechaDeFinConHoraCero, "sol", 11)
        .forEach(prestatario -> {
        	System.out.println( prestatario );
        });
		
	}

}
