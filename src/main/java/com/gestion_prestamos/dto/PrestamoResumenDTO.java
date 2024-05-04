package com.gestion_prestamos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PrestamoResumenDTO(
		Integer id,
		String estado,
		LocalDateTime fechaInicio,
		BigDecimal monto
) {
}
