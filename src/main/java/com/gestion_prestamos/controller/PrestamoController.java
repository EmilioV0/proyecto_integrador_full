package com.gestion_prestamos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.entity.prestamos;
import com.gestion_prestamos.services.PrestamosService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api")
public class PrestamoController {
	
	@Autowired
	private PrestamosService prestamoSer;
	
	private static User userLoguedo;
	
	
	@GetMapping
	public String GetPrestamo(HttpSession session, Model model) {
		PrestamoController.userLoguedo = (User) session.getAttribute("userSession");
		List<prestamos> prestamo = prestamoSer.findAll();
		model.addAttribute("prestamo",prestamo);
		
		return "SE ve la pagina para el get";
	}
	
	
	
}
