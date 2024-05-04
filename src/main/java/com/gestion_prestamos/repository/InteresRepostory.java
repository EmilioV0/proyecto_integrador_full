package com.gestion_prestamos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.gestion_prestamos.entity.Interes;
import com.gestion_prestamos.entity.InteresId;

public interface InteresRepostory extends Repository<Interes, InteresId>{
	
	@Query(value = """
			SELECT 
				group_concat(t.price)
			FROM Interes t INNER JOIN t.monto m
			GROUP BY m.id
			""")
	String[] getIntereses();
	
}
