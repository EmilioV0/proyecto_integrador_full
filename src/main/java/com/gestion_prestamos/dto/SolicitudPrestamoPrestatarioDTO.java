package com.gestion_prestamos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SolicitudPrestamoPrestatarioDTO(
		Integer id,
		String prestatario,
		LocalDateTime fechaInicio,
		BigDecimal monto
) {
	
}
