package com.gestion_prestamos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gestion_prestamos.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public String getUsers(Model model) {		
		model.addAttribute("users", userService.findByIdGrupo(2));
		return "cliente";
	}
	
}
