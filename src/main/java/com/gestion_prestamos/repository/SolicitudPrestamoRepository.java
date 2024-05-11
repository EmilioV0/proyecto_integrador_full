package com.gestion_prestamos.repository;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO;
import com.gestion_prestamos.entity.SolicitudPrestamo;

@Repository
public interface SolicitudPrestamoRepository extends JpaRepository<SolicitudPrestamo, Integer> {

	@Query(value = """
			SELECT new com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO
			(
				p.id,
				p.estado,
				p.fechaInicio,
				p.monto
			)
			FROM SolicitudPrestamo p WHERE p.idPrestatario = :idPrestatario
			""")
	List<SolicitudPrestamoResumenDTO> buscarTodosPorPrestatario(Integer idPrestatario);
	@Query(value = """
			SELECT new com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO(
				p.id,
				CONCAT(press.nombre, ' ', press.apellido) prestatario,
				p.fechaInicio,
				p.monto
			)
			FROM SolicitudPrestamo p JOIN p.prestatario press
			WHERE p.fechaInicio >= :fechaDeInicio 
			AND p.fechaFin <= :fechaDeFin 
			AND CONCAT(press.nombre, ' ', press.apellido) LIKE CONCAT('%',:text,'%')
			AND p.idPrestamista = :idPrestamista 
			AND p.estado = 'Pendiente'
			""")
	List<SolicitudPrestamoPrestatarioDTO> buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(
				LocalDateTime fechaDeInicio,
				LocalDateTime fechaDeFin,
				String text,
				int idPrestamista
			);
 
}
