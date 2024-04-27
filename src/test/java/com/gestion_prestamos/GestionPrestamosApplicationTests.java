package com.gestion_prestamos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.repository.UserRepository;

@SpringBootTest
class GestionPrestamosApplicationTests {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder by;
	 
	@Test 
	void contextLoads() {
		 //User user = repo.findById(1).get();
		// repo.findByIdGrupo( user.getId() ).forEach(x -> System.out.println(x));
		 System.out.println( by.encode("emilio") );
		// System.out.println( repo.findByLogin("emiliovo").get() );
	}

}
 