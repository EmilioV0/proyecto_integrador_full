package com.gestion_prestamos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestion_prestamos.repository.TiempoRepository;

@SpringBootTest
public class TiempoTest {

	@Autowired
	private TiempoRepository tiempoRepo;
	
	@Test
	void diasDisponibles() {
		for ( String item : tiempoRepo.findAll() ) {
			System.out.println( item );
		}
	}

}
