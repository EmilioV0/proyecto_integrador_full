package com.gestion_prestamos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion_prestamos.dto.SolicitudPrestamoResumenDTO;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.services.InteresService;
import com.gestion_prestamos.services.SolicitudPrestamoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/prestatario")
public class PrestatarioController {

	private final InteresService interesService;
	private final SolicitudPrestamoService solicitudPrestamoService;
	private static User userLoguedo;
	
	public PrestatarioController(InteresService interesService,
			SolicitudPrestamoService solicitudPrestamoService) {
		this.interesService = interesService;
		this.solicitudPrestamoService = solicitudPrestamoService;
	}

	@GetMapping
	public String index(Model model, HttpSession session) {
		PrestatarioController.userLoguedo = (User) session.getAttribute("userSession");
		int idPrestatario = PrestatarioController.userLoguedo.getId();
		List<SolicitudPrestamoResumenDTO> misSolicitudes = solicitudPrestamoService.buscarTodosPorPrestatario(idPrestatario);
		
		
		model.addAttribute("intereses", interesService.getIntereses());
		model.addAttribute("solicitudesPrestamos", misSolicitudes);
		
		return "prestamos";
	}




}
