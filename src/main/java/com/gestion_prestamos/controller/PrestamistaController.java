package com.gestion_prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/prestamistas")
public class PrestamistaController {

	
	
	public PrestamistaController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(value = "/solicitudes-de-prestamos")
	public String getSolicitudes() {
		return "FitroSolicitud";
	}
	
}
