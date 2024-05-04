package com.gestion_prestamos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gestion_prestamos.dto.CrearPrestamoDTO;
import com.gestion_prestamos.entity.Prestamo;
import com.gestion_prestamos.entity.User;
import com.gestion_prestamos.services.PrestamosService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {
	
	@Autowired
	private PrestamosService prestamoSer;
	
	private static User userLoguedo;
	
	@PostMapping
	@ResponseBody
	public Prestamo save(@RequestBody CrearPrestamoDTO nuevoPrestamo, HttpSession session) {
		PrestamoController.userLoguedo = (User) session.getAttribute("userSession");
		Prestamo prestamo = prestamoSer.save(nuevoPrestamo, userLoguedo);	
		return prestamo;
	}
	
	
	
}
