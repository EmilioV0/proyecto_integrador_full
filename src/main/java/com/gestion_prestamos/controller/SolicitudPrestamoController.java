package com.gestion_prestamos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.dto.SolicitudPrestamoPrestatarioDTO;
import com.gestion_prestamos.entity.SolicitudPrestamo;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.services.SolicitudPrestamoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/solicitudes-prestamos")
public class SolicitudPrestamoController {

	@Autowired
	private SolicitudPrestamoService solicitudPrestamoSer;

	private static User userLoguedo;

	@PostMapping
	@ResponseBody
	public SolicitudPrestamo save(@RequestBody CrearPrestamoDTO nuevoPrestamo, HttpSession session) {
		SolicitudPrestamoController.userLoguedo = (User) session.getAttribute("userSession");
		SolicitudPrestamo prestamo = solicitudPrestamoSer.save(nuevoPrestamo, userLoguedo);
		return prestamo;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<SolicitudPrestamoPrestatarioDTO>> getSolPresXRangoFecha(
				@RequestParam("fechaInicio") String fechaInicio,
				@RequestParam("fechaFin") String fechaFin,
				@RequestParam("text") String text,
				HttpSession session
			) {
		SolicitudPrestamoController.userLoguedo = (User) session.getAttribute("userSession");
		int idPrestamista = SolicitudPrestamoController.userLoguedo.getId();
		List<SolicitudPrestamoPrestatarioDTO> body = solicitudPrestamoSer
				.buscarSolicitudesDePrestamoPorPrestatarioYRangoDeFechas(fechaInicio, fechaFin, text, idPrestamista);
		
		return ResponseEntity.ok(body);
	}
	
	@GetMapping(value = "/solicitudes-de-prestamos")
	public String getSolicitudes() {
		return "FitroSolicitud";
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<SolicitudPrestamo> getById(@PathVariable int id) {
		
		
		return null;
	}
	
	
}
