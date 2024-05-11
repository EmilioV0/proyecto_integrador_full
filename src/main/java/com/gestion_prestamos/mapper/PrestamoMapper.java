package com.gestion_prestamos.mapper;

import java.time.LocalDateTime;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.entity.Prestamo;
import com.gestion_prestamos.entity.User;

public class PrestamoMapper {

	private static final Prestamo prestamo = new Prestamo();

	private PrestamoMapper() {}

	public static Prestamo toPrestamo(CrearPrestamoDTO nuevoPrestamo,
										User user) {

		LocalDateTime fechaInicio = LocalDateTime.now();

		prestamo.setMonto(nuevoPrestamo.monto());
		prestamo.setFechaFin( LocalDateTime.parse( nuevoPrestamo.fechaFin() + "T00:00:00") );
		prestamo.setFechaInicio( fechaInicio );
		prestamo.setDias(nuevoPrestamo.dias());
		prestamo.setPagoDiario( nuevoPrestamo.pagoPorDia() );
		prestamo.setIdPrestamista( user.getIdGrupo() );
		prestamo.setIdPrestatario( user.getId() );
		prestamo.setEstado("Pendiente");

		return prestamo;
	}

}
