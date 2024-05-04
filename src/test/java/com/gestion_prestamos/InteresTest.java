package com.gestion_prestamos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gestion_prestamos.repository.InteresRepostory;

@SpringBootTest
public class InteresTest {
	
	@Autowired
	private InteresRepostory interesRepository;
	
	@Test
	void getIntereses() {
		for ( String row : interesRepository.getIntereses() ) {
			System.out.println( row );
		}
	}
}
