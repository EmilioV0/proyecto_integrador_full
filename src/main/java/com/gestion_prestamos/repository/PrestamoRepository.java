package com.gestion_prestamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion_prestamos.dto.PrestamoResumenDTO;
import com.gestion_prestamos.entity.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

	@Query(value = """
			SELECT new com.gestion_prestamos.dto.PrestamoResumenDTO
			(
				p.id,
				p.estado,
				p.fechaInicio,
				p.monto
			)
			FROM Prestamo p WHERE p.idPrestatario = :idPrestatario
			""")
	List<PrestamoResumenDTO> buscarTodosPorPrestatario(Integer idPrestatario);

}
