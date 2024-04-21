package com.gestion_prestamos.dto;

public record UserAuthenticationDTO(
	Integer id,
	String rol,
	String password
) {}
