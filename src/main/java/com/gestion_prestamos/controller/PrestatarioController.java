package com.gestion_prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion_prestamos.services.InteresService;

@Controller
@RequestMapping(value = "/prestatario")
public class PrestatarioController {

	private final InteresService interesService;

	public PrestatarioController(InteresService interesService) {
		this.interesService = interesService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("intereses", interesService.getIntereses());
		return "prestamos";
	}
	

}
