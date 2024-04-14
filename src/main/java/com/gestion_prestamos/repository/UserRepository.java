package com.gestion_prestamos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.gestion_prestamos.entity.User;

public interface UserRepository extends Repository<User, Integer> {
	
	Optional<User> findById(int id);
	
	@Query(value = """
			SELECT u from User u WHERE u.idGrupo = :id
			AND u.id <> :id
			""")
	List<User> findByIdGrupo(int id);
	
	User save(User user); // update y create.
	
}
