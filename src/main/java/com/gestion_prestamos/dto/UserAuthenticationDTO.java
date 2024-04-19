package com.gestion_prestamos.dto;

public record UserAuthenticationDTO(
	String rol,
	String password
) {}
