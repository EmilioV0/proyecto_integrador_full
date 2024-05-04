package com.gestion_prestamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.gestion_prestamos.entity.Tiempo;

public interface TiempoRepository extends Repository<Tiempo, Integer>{
	
	@Query(value = """
			SELECT 
				t.dias
			FROM Tiempo t
			""")
	String[] findAll();
}
