package com.gestion_prestamos.dto;

import java.math.BigDecimal;

public record CrearPrestamoDTO(
	BigDecimal monto,
    String fechaInicio,
    String fechaFin,
    int dias,
    BigDecimal pagoPorDia
) {
	
}
